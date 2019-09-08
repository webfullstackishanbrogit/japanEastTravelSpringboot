/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.service;

import net.epic.email.dto.SMTPSettingsDTO;
import net.epic.email.entity.SMTPSettings;
import net.epic.email.repository.SMTPSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * SMTP Settings for fetching configurations from DB
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Service
public class SMTPSettingsService {

    private SMTPSettingsRepository smtpSettingsRepository;

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param smtpSettingsRepository SMTPSettingsRepository See {@link SMTPSettingsRepository}
     */
    @Autowired
    public SMTPSettingsService(SMTPSettingsRepository smtpSettingsRepository) {
        this.smtpSettingsRepository = smtpSettingsRepository;
    }

    /**
     * Update SMTP Settings from the DB
     *
     * @param smtpSettingsDTO Email Settings DTO See {@link SMTPSettingsDTO}
     * @return Updated SMTPSettings
     */
    public SMTPSettings updateSettings(SMTPSettingsDTO smtpSettingsDTO) {
        SMTPSettings settings = smtpSettingsRepository.findFirstByOrderByUpdatedTimeDesc();
        settings.setUpdatedTime(new Date());
        settings.setHost(smtpSettingsDTO.getHost());
        settings.setPort(smtpSettingsDTO.getPort());
        settings.setAuth(smtpSettingsDTO.isAuth());
        settings.setUsername(smtpSettingsDTO.getUsername());
        settings.setPassword(smtpSettingsDTO.getPassword());
        settings.setTls(smtpSettingsDTO.isTls());
        settings.setConnectionTimeout(smtpSettingsDTO.getConnectionTimeout());
        settings.setTimeout(smtpSettingsDTO.getTimeout());
        settings.setWriteTimeout(smtpSettingsDTO.getWriteTimeout());
        settings.setProtocol(smtpSettingsDTO.getProtocol());

        return smtpSettingsRepository.save(settings);

    }

    /**
     * Fetch most recent settings from DB
     *
     * @return Current Settings from DB
     */
    public SMTPSettings fetchSettings() {
        return smtpSettingsRepository.findFirstByOrderByUpdatedTimeDesc();
    }

}
