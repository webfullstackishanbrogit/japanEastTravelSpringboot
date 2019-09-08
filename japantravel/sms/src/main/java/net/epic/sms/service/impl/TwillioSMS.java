/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.sms.service.impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import net.epic.sms.entity.TwillioSettings;
import net.epic.sms.service.SMSLogService;
import net.epic.sms.service.SMSService;
import net.epic.sms.service.TwillioSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TwillioSMS implements SMSService {


    private TwillioSettingsService twillioSettingsService;
    private SMSLogService smsLogService;

    @Autowired
    public TwillioSMS(TwillioSettingsService twillioSettingsService, SMSLogService smsLogService) {
        this.twillioSettingsService = twillioSettingsService;
        this.smsLogService = smsLogService;

    }

    @Override
    public String sendSMS(String from, String to, String content) {

        int logID = smsLogService.addToLog(from, to, content, null, false, new Date());

        TwillioSettings settings = twillioSettingsService.getTwillioSettings();
        Twilio.init(settings.getAccountSID(), settings.getAuthToken());
        Message message = Message.creator(new PhoneNumber(to),
                new PhoneNumber(from),
                content).create();

        String messageSid = message.getSid();

        if (messageSid != null) {
            smsLogService.updateLog(logID, messageSid, true, new Date());
        }

        return messageSid;
    }
}
