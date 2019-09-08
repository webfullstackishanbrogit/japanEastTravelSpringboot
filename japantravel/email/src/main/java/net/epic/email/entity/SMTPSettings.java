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
import java.util.Date;

/**
 * Entity class for SMTP Settings
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Entity
@Table(name = "smtp_settings")
@XmlRootElement
@Data
@Audited
public class SMTPSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "smtp_host")
    private String host;
    @Column(name = "smtp_port")
    private int port;
    @Column(name = "smtp_username")
    private String username;
    @Column(name = "smtp_password")
    private String password;
    @Column(name = "protocol")
    private String protocol;
    @Column(name = "auth")
    private boolean auth;
    @Column(name = "timeout")
    private int timeout;
    @Column(name = "connection_timeout")
    private int connectionTimeout;
    @Column(name = "write_timeout")
    private int writeTimeout;
    @Column(name = "tls")
    private boolean tls;
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
}
