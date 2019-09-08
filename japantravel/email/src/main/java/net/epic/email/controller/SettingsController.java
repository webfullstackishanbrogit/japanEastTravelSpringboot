/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email.controller;

import net.epic.email.dto.SMTPSettingsDTO;
import net.epic.email.service.SMTPSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for updating SMTP Settings
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@RestController
public class SettingsController {

    private SMTPSettingsService smtpSettingsService;

    /**
     * Spring Autowired constructor for dependency injection
     *
     * @param smtpSettingsService SMTPSettings service Autowired dependency See {@link SMTPSettingsService}
     */
    @Autowired
    public SettingsController(SMTPSettingsService smtpSettingsService) {
        this.smtpSettingsService = smtpSettingsService;
    }

    /**
     * Controller endpoint for updating SMTP Settings with new configurations
     *
     * @param smtpSettingsDTO A DTO class with required fields See {@link SMTPSettingsDTO}
     * @return TEXT acknowledgement of settings updated
     */
    @PostMapping("/updateSettings")
    public String updateSettings(@RequestBody SMTPSettingsDTO smtpSettingsDTO) {
        smtpSettingsService.updateSettings(smtpSettingsDTO);
        return "SETTINGS UPDATED. PLEASE RESTART SERVICE OR CALL REFRESH ENDPOINT TO APPLY SETTINGS";
    }
}
