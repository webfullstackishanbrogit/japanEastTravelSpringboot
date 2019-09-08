/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.sms.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "sms_log")
@XmlRootElement
@Data
@Audited
public class SMSLog {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sms_id")
    private Integer smsId;

    @Basic(optional = false)
    @Column(name = "sender")
    private String sender;

    @Basic(optional = false)
    @Column(name = "reciever")
    private String receiver;

    @Basic(optional = false)
    @Column(name = "delivered")
    private boolean delivered;

    @Basic(optional = false)
    @Column(name = "content")
    private String content;

    @Basic(optional = false)
    @Column(name = "tracking_info")
    private String trackingInfo;

    @Column(name = "sent_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;


}
