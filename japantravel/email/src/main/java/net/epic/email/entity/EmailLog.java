/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Entity class for Email Status Logging
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Entity
@Table(name = "email_log")
@XmlRootElement
@Data
@Audited
public class EmailLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sent_by")
    private String sentBy;
    @Column(name = "sent_to")
    private String sentTo;
    @Lob
    @Column(name = "subject")
    private String subject;
    @Lob
    @Column(name = "body")
    private String body;
    @Column(name = "sent_status")
    private Boolean sentStatus;
    @Column(name = "sent_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailLogId")
    private Collection<EmailAttachments> emailAttachmentsCollection;
}
