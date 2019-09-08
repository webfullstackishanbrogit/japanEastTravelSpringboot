/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.config;

import net.epic.email.entity.SMTPSettings;
import net.epic.email.service.SMTPSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.MessagingException;
import java.util.Properties;

/**
 * Configuration Class for JavaMailSender
 * Configuration is fetched from DB during the boot stage of the application.
 * Any update to changes will not be visible until a restart or refresh scope is initiated.
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Configuration
public class SpringMailConfig {

    private SMTPSettingsService smtpSettingsService;

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param smtpSettingsService SMTPSettings service Autowired dependency See {@link SMTPSettingsService}
     */
    @Autowired
    public SpringMailConfig(SMTPSettingsService smtpSettingsService) {
        this.smtpSettingsService = smtpSettingsService;
    }

    /**
     * Java Mail Properties bean fetches initial configuration from DB
     *
     * @return MailProperties object created with configured properties
     */
    @Bean
    public MailProperties confEmailSMTP() {
        MailProperties properties = new MailProperties();
        SMTPSettings settings = smtpSettingsService.fetchSettings();
        properties.setHost(settings.getHost());
        properties.setPort(settings.getPort());
        properties.setUsername(settings.getUsername());
        properties.setPassword(settings.getPassword());
        properties.setProtocol(settings.getProtocol());
        return properties;
    }

    /**
     * Additional properties configured from DB
     *
     * @return Properties object created with subsidiary configurations fetched from DB
     */
    @Bean(name = "mailProperties")
    public Properties mailProperties() {
        SMTPSettings settings = smtpSettingsService.fetchSettings();
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", settings.isAuth());
        properties.put("mail.smtp.connectiontimeout", settings.getConnectionTimeout());
        properties.put("mail.smtp.timeout", settings.getTimeout());
        properties.put("mail.smtp.writetimeout", settings.getWriteTimeout());
        properties.put("mail.smtp.starttls.enable", settings.isTls());
        return properties;
    }

    /**
     * Spring Mail Implementation Bean for JavaMail
     *
     * @param mailProperties MailProperties configured with DB parameters
     * @param properties     Additional properties configured by DB
     * @return Fully instantiated JavaMail Bean for mail sending
     * @throws MessagingException Thrown if fails to apply configurations or incorrect settings such as password or username etc.
     */
    @Bean
    public JavaMailSenderImpl mailSender(MailProperties mailProperties,
                                         @Qualifier("mailProperties") Properties properties) throws MessagingException {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setProtocol(mailProperties.getProtocol());
        javaMailSender.setHost(mailProperties.getHost());
        javaMailSender.setPort(mailProperties.getPort());
        javaMailSender.setUsername(mailProperties.getUsername());
        javaMailSender.setPassword(mailProperties.getPassword());
        javaMailSender.setDefaultEncoding("UTF-8");
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.testConnection();

        return javaMailSender;
    }
}
