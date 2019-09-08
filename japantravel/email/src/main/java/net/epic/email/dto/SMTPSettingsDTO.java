/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * A DTO class with fields for the SMTP settings updating purposes
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Data
public class SMTPSettingsDTO {

    @NotNull
    private String host;
    @NotNull
    private int port;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String protocol;
    @NotNull
    private boolean auth;
    @NotNull
    private int timeout;
    @NotNull
    private int connectionTimeout;
    @NotNull
    private int writeTimeout;
    @NotNull
    private boolean tls;

}
