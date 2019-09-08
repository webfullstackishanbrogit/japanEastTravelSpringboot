/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.service;

import net.epic.email.entity.EmailAttachments;
import net.epic.email.entity.EmailLog;
import net.epic.email.repository.EmailAttachmentRepository;
import net.epic.email.repository.EmailLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

/**
 * Service for handling Email Logs
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class EmailLogService {

    private EmailLogRepository emailLogRepository;
    private EmailAttachmentRepository emailAttachmentRepository;

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param emailLogRepository        Email log repository See {@link EmailLogRepository}
     * @param emailAttachmentRepository Email attachment log repository See {@link EmailAttachmentRepository}
     */
    @Autowired
    public EmailLogService(EmailLogRepository emailLogRepository,
                           EmailAttachmentRepository emailAttachmentRepository) {
        this.emailLogRepository = emailLogRepository;
        this.emailAttachmentRepository = emailAttachmentRepository;
    }

    /**
     * Creates initial mail log entry for the email to be sent
     *
     * @param from    From email address
     * @param to      To email address
     * @param subject Subject of the email
     * @param body    Text body of the email
     * @return Email log entry
     */
    public EmailLog addToLog(String from, String to, String subject, String body) {

        EmailLog log = new EmailLog();

        log.setSentTo(to);
        log.setSentBy(from);
        log.setSubject(subject);
        log.setBody(body);
        log.setSentStatus(false);
        log.setSentTime(new Date());

        return emailLogRepository.save(log);
    }

    /**
     * Mark email as successfully sent
     *
     * @param log Email Log Object
     */
    public void markAsSent(EmailLog log) {
        log.setSentStatus(true);
        log.setSentTime(new Date());
        emailLogRepository.save(log);
    }

    /**
     * Mark email as successfully sent
     *
     * @param logID Email id to mark as sent
     */
    public void markAsSent(int logID) {
        Optional<EmailLog> log = emailLogRepository.findById(logID);
        if (log.isPresent()) {
            EmailLog emailLog = log.get();
            emailLog.setSentTime(new Date());
            emailLog.setSentStatus(true);
        }
    }

    /**
     * Check status of a sent mail
     *
     * @param logID ID of the email log
     * @return Status of the email
     */
    public String checkStatus(int logID) {
        Optional<EmailLog> log = emailLogRepository.findById(logID);
        if (!log.isPresent()) {
            return "404";
        } else {
            EmailLog emailLog = log.get();
            if (emailLog.getId() == -1) {
                return "NOT_DELIVERED";
            } else {
                return "DELIVERED";
            }
        }
    }

    /**
     * Add Attachments to an email log
     *
     * @param log            Log object of email
     * @param attachmentPath Attachment file path
     */
    public void addAttachmentToLog(EmailLog log, String attachmentPath) {

        EmailAttachments attachment = new EmailAttachments();
        attachment.setAttachmentPath(attachmentPath);
        attachment.setEmailLogId(log);
        emailAttachmentRepository.save(attachment);
    }
}
