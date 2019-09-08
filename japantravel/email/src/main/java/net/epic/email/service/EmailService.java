/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.service;

import net.epic.email.dto.TemplateEmailDTO;
import net.epic.email.entity.EmailAttachments;
import net.epic.email.entity.EmailLog;
import net.epic.email.repository.EmailLogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Email Service for sending emails
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class EmailService {

    private EmailLogService emailLogService;
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;
    private EmailLogRepository emailLogRepository;
    private Logger logger = LogManager.getLogger(EmailService.class);

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param emailLogService Email logging service See {@link EmailLogService}
     * @param javaMailSender  Java Mail Sender implementation of Spring Boot See {@link JavaMailSender}
     * @param templateEngine  Templating engine for Thymeleaf See {@link TemplateEngine}
     */
    @Autowired
    public EmailService(EmailLogService emailLogService, JavaMailSender javaMailSender, TemplateEngine templateEngine, EmailLogRepository emailLogRepository) {
        this.emailLogService = emailLogService;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.emailLogRepository = emailLogRepository;
    }

    /**
     * Common function for sending emails with text bodies
     *
     * @param from        From email address
     * @param to          To email address
     * @param subject     Subject of the email
     * @param body        Body of the email
     * @param attachments Attachment list to be attached to the email
     * @return ID of the email log
     */
    public int sendEmail(String from, String to, String subject, String body, List<String> attachments) {

        EmailLog log = emailLogService.addToLog(from, to, subject, body);

        if (attachments.isEmpty()) {
            return sendEmail(from, to, subject, body);
        } else {

            try {

                MimeMessageHelper helper = prepareEmail(from, to, subject);
                setTextBody(helper, body);
                addAttachment(helper, attachments, log);
                sendEmail(helper.getMimeMessage(), log);

            } catch (MessagingException e) {

                logger.error(e);
            }
        }
        return log.getId();

    }

    /**
     * Sending emails with template body and dynamic values
     *
     * @param from          From email address
     * @param to            To email address
     * @param subject       Subject of the email
     * @param templatePath  Template path to be used as body
     * @param keyValuePairs Key value pairs to be used for dynamic content in the template
     * @param attachments   Attachment file list to be attached to the email
     * @return Log ID of the email log
     */
    public int sendEmailWithTemplate(String from, String to, String subject, String templatePath, Map<String, String> keyValuePairs, List<String> attachments) {

        EmailLog log = new EmailLog();

        if (keyValuePairs.isEmpty()) {

            return sendEmailWithTemplate(from, to, subject, templatePath, attachments);

        } else {

            try {

                MimeMessageHelper helper = prepareEmail(from, to, subject);
                String content = setTemplateContent(new Context(), keyValuePairs, templatePath);
                log = emailLogService.addToLog(from, to, subject, content);
                helper.setText(content, true);
                addAttachment(helper, attachments, log);
                sendEmail(helper.getMimeMessage(), log);

            } catch (MessagingException e) {

                logger.error(e);

            }
        }
        return log.getId();
    }

    /**
     * Sending mails with text bodies without attachments
     *
     * @param from    From email address
     * @param to      To email address
     * @param subject Subject of the email
     * @param body    Body of the email
     * @return ID of the email log
     */
    private int sendEmail(String from, String to, String subject, String body) {

        EmailLog log = emailLogService.addToLog(from, to, subject, body);

        try {
            MimeMessageHelper helper = prepareEmail(from, to, subject);
            setTextBody(helper, body);
            sendEmail(helper.getMimeMessage(), log);
        } catch (MessagingException e) {
            logger.error(e);
        }
        return log.getId();
    }

    /**
     * Sending emails with template body and attachments
     *
     * @param from         From email address
     * @param to           To email address
     * @param subject      Subject of the email
     * @param templatePath File path of the template
     * @param attachments  Attachment list to be attached to the email
     * @return Log ID of the email log
     */
    private int sendEmailWithTemplate(String from, String to, String subject, String templatePath, List<String> attachments) {

        EmailLog log = new EmailLog();

        try {

            MimeMessageHelper helper = prepareEmail(from, to, subject);
            String content = setTemplateContent(new Context(), templatePath);
            log = emailLogService.addToLog(from, to, subject, content);
            addAttachment(helper, attachments, log);
            helper.setText(content, true);
            sendEmail(helper.getMimeMessage(), log);

        } catch (MessagingException e) {

            logger.error(e);
        }

        return log.getId();
    }

    /**
     * Method to handle sending email of all types
     *
     * @param message Email message object
     * @return TRUE if message sent successfully or FALSE if failed
     * @deprecated This function now has additional parameter to pass EmailLog entity
     */
    @Deprecated
    private boolean sendEmail(MimeMessage message) {
        try {
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            logger.info(e);
            return false;
        }
    }

    /**
     * Method to handle sending email of all types
     *
     * @param message Email message object
     * @param log     Email Log entity to set mark as sent true if email successfully passes through
     */
    private void sendEmail(MimeMessage message, EmailLog log) {
        try {
            javaMailSender.send(message);
            emailLogService.markAsSent(log);
        } catch (Exception e) {
            logger.info(e);
        }
    }

    /**
     * Set template body for the email
     *
     * @param context      Content of the email body
     * @param templatePath Template path to be used
     * @return String mail body as text
     */
    private String setTemplateContent(Context context, String templatePath) {
        return templateEngine.process(templatePath, context);
    }

    /**
     * Set dynamic mail body with template
     *
     * @param context      Context of the email
     * @param keyValueMap  Key value map of dynamic content
     * @param templatePath Template file path
     * @return Email body as a text
     */
    private String setTemplateContent(Context context, Map<String, String> keyValueMap, String templatePath) {

        Set<String> keySet = keyValueMap.keySet();
        String[] keys = keySet.toArray(new String[0]);
        for (String key : keys) {
            context.setVariable(key, keyValueMap.get(key));
        }

        return templateEngine.process(templatePath, context);
    }

    /**
     * Method for setting email text body
     *
     * @param helper Message object generated
     * @param body   Text body to be embedded
     * @return Helper object with created body
     * @throws MessagingException If fails to create the text body
     */
    private MimeMessageHelper setTextBody(MimeMessageHelper helper, String body) throws MessagingException {
        helper.setText(body);
        return helper;
    }

    /**
     * Add attachment to the email
     *
     * @param helper    Helper email object
     * @param filePaths File paths of the attachments
     * @param log       Email Log object
     * @return Prepared email with attachments
     * @throws MessagingException Throws if the email is failed to get generated
     */
    private MimeMessageHelper addAttachment(MimeMessageHelper helper, List<String> filePaths, EmailLog log) throws MessagingException {

        for (String path : filePaths) {
            FileSystemResource file = new FileSystemResource(path);
            helper.addAttachment(file.getFilename(), file);
            emailLogService.addAttachmentToLog(log, path);
        }

        return helper;
    }

    /**
     * Prepare initial email with basics
     *
     * @param from    From email address
     * @param to      To email address
     * @param subject Subject of the email
     * @return Email Helper object
     * @throws MessagingException If fails to create email object
     */
    private MimeMessageHelper prepareEmail(String from, String to, String subject) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        return helper;
    }

    /**
     * This method is used to get all details of email according to email id and details pass to sendEmail method
     *
     * @param id email id to select details from the database tables
     * @return Email id
     */
    public int resendPlainMail(int id) {
        try {
            Optional<EmailLog> findObject = emailLogRepository.findById(id);
            EmailLog object = findObject.get();
            String from = object.getSentBy();
            String to = object.getSentTo();
            String subject = object.getSubject();
            String body = object.getBody();

            Collection<EmailAttachments> attachments = object.getEmailAttachmentsCollection();
            List<String> attachmentPath = new ArrayList<>();
            for (EmailAttachments attach : attachments) {
                attachmentPath.add(attach.getAttachmentPath());
            }

            return sendEmail(from, to, subject, body, attachmentPath);
        } catch (Exception e) {
            logger.error(e);
        }
        return -1;
    }

    /**
     * This method is used to get all details of email according to email id and email template key value pairs
     *
     * @param id               email id to filter details from the database
     * @param templateEmailDTO send email template key value pairs
     * @return email id
     */
    public int reSendEmailWithTemplate(int id, TemplateEmailDTO templateEmailDTO) {
        try {
            Optional<EmailLog> findObject = emailLogRepository.findById(id);
            EmailLog object = findObject.get();
            String from = object.getSentBy();
            String to = object.getSentTo();
            String subject = object.getSubject();
            String templatePath = templateEmailDTO.getTemplatePath();

            Collection<EmailAttachments> attachments = object.getEmailAttachmentsCollection();
            List<String> attachmentPath = new ArrayList<>();
            for (EmailAttachments attach : attachments) {
                attachmentPath.add(attach.getAttachmentPath());
            }

            if (templateEmailDTO.getKeyValuePairs().isPresent()) {
                return sendEmailWithTemplate(from, to, subject, templatePath, templateEmailDTO.getKeyValuePairs().get(), attachmentPath);
            } else {
                return sendEmailWithTemplate(from, to, subject, templatePath, new HashMap<>(), attachmentPath);
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return -1;
    }
}
