/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/***
 * The DTO class for Plain Emails with text body
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Data
public class PlainEmailDTO implements Serializable {
    private String from;
    private List<String> to;
    private String body;
    private String subject;
    private List<String> attachments;
}
