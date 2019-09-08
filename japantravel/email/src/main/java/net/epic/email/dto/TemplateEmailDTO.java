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
import java.util.Map;
import java.util.Optional;

/***
 * A DTO class for emails with Template body
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Data
public class TemplateEmailDTO implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private String from;
    private List<String> to;
    private String templatePath;
    private String subject;
    private List<String> attachments;
    private transient Optional<Map<String, String>> keyValuePairs;
}
