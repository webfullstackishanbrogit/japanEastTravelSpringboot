package net.epic.email.controller;

import net.epic.email.dto.TemplateEmailDTO;
import net.epic.email.service.EmailLogService;
import net.epic.email.service.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * REST controller endpoint for resend Emails according to Email ID and check status
 *
 * @author Ishan
 * @version 1.0.0
 * @since Ver. 1.0.0
 */

@RestController
public class ResendController {
    private EmailService emailService;
    private EmailLogService emailLogService;
    private Logger logger = LogManager.getLogger(RestController.class);

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param emailService    Spring Autowired dependency, See {@link EmailService}
     * @param emailLogService Spring Autowired dependency, See {@link EmailLogService}
     */

    public ResendController(EmailService emailService, EmailLogService emailLogService) {
        this.emailService = emailService;
        this.emailLogService = emailLogService;

    }

    /**
     * Controller endpoint for Resending plain text emails with or without attachments according to email id
     *
     * @param id Email id for resending mail with stored database values.
     * @return Map of email id for each receiver and status of the email
     */
    @PutMapping("/resendPlainTxt/{id}")
    public Map<Integer, String> resendPlainText(@PathVariable int id) {
        Map<Integer, String> logList = new HashMap<>();
        int i = emailService.resendPlainMail(id);
        if (i != -1) {
            logList.put(i, emailLogService.checkStatus(i));
        } else {
            logger.error("There is no Email id like that");
        }
        return logList;
    }

    /**
     * Controller endpoint for Resending emails with predefined template with or without attachments according to email id
     *
     * @param id               Email id for resending mail with stored database values.
     * @param templateEmailDTO A DTO class with required fields. See {@link TemplateEmailDTO}
     * @return Map of email id for each receiver and status of the email
     */

    @PutMapping("/resendEmailTemplate/{id}")
    public Map<Integer, String> resendMailTemplate(@PathVariable int id, @RequestBody TemplateEmailDTO templateEmailDTO) {
        Map<Integer, String> logList = new HashMap<>();
        int i = emailService.reSendEmailWithTemplate(id, templateEmailDTO);
        if (i != -1) {
            logList.put(i, emailLogService.checkStatus(i));
        } else {
            logger.error("There is no Email id like that");
        }
        return logList;
    }
}

