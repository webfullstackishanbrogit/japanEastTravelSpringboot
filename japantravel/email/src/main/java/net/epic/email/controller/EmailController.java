/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.controller;

import net.epic.email.dto.PlainEmailDTO;
import net.epic.email.dto.TemplateEmailDTO;
import net.epic.email.service.EmailLogService;
import net.epic.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller endpoint for sending emails and checking delivery status
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@RestController
public class EmailController {

    private EmailService emailService;
    private EmailLogService emailLogService;

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param emailService    Spring Autowired dependency, See {@link EmailService}
     * @param emailLogService Spring Autowired dependency, See {@link EmailLogService}
     */
    @Autowired
    public EmailController(EmailService emailService, EmailLogService emailLogService) {
        this.emailService = emailService;
        this.emailLogService = emailLogService;
    }

    /**
     * Controller endpoint for sending plain text emails with or without attachments
     *
     * @param plainEmailDTO A DTO class with required fields. See {@link PlainEmailDTO}
     * @return Map of email id for each receiver and status of the email
     */
    @PostMapping("/sendPlainEmail")
    public Map<Integer, String> sendPlainEmail(@RequestBody PlainEmailDTO plainEmailDTO) {

        List<String> to = plainEmailDTO.getTo();
        Map<Integer, String> logList = new HashMap<>();

        for (String sendTo : to) { //For each person email was addressed to

            int i = emailService.sendEmail(plainEmailDTO.getFrom(),
                    sendTo,
                    plainEmailDTO.getSubject(),
                    plainEmailDTO.getBody(),
                    plainEmailDTO.getAttachments());

            logList.put(i, emailLogService.checkStatus(i));
        }
        return logList;
    }

    /**
     * Controller endpoint for sending emails with predefined template with or without attachments
     *
     * @param templateEmailDTO A DTO class with required fields. See {@link TemplateEmailDTO}
     * @return Map of email id for each receiver and status of the email
     */
    @PostMapping("/sendEmailTemplate")
    public Map<Integer, String> sendEmailTemplate(@RequestBody TemplateEmailDTO templateEmailDTO) {

        List<String> to = templateEmailDTO.getTo();
        Map<Integer, String> logList = new HashMap<>();

        for (String sendTo : to) {

            int i;

            if (templateEmailDTO.getKeyValuePairs().isPresent()) {

                i = emailService.sendEmailWithTemplate(templateEmailDTO.getFrom(),
                        sendTo,
                        templateEmailDTO.getSubject(),
                        templateEmailDTO.getTemplatePath(),
                        templateEmailDTO.getKeyValuePairs().get(),
                        templateEmailDTO.getAttachments());
            } else {

                i = emailService.sendEmailWithTemplate(templateEmailDTO.getFrom(),
                        sendTo,
                        templateEmailDTO.getSubject(),
                        templateEmailDTO.getTemplatePath(),
                        new HashMap<>(),
                        templateEmailDTO.getAttachments());
            }

            logList.put(i, emailLogService.checkStatus(i));

        }

        return logList;
    }

    /**
     * Controller endpoint for checking delivery status of an Email.
     *
     * @param logId ID returned when email was sent.
     * @return Status of the email (DELIVERED OR NOT DELIVERED)
     */
    @GetMapping("/checkStatus/{emailLogId}")
    public String checkStatusOfEmail(@PathVariable("emailLogId") int logId) {
        return emailLogService.checkStatus(logId);

    }
}
