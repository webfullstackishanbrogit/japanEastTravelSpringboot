/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.sms.service;

import net.epic.sms.entity.TwillioSettings;
import net.epic.sms.repository.TwillioSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwillioSettingsService {

    private TwillioSettingsRepository twillioSettingsRepository;

    @Autowired
    public TwillioSettingsService(TwillioSettingsRepository twillioSettingsRepository) {
        this.twillioSettingsRepository = twillioSettingsRepository;
    }

    public TwillioSettings getTwillioSettings() {
        return twillioSettingsRepository.findFirstByOrderByUpdatedAtDesc();
    }
}
