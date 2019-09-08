/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.sms.service;

import net.epic.sms.entity.SMSLog;
import net.epic.sms.repository.SMSLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SMSLogService {

    private SMSLogRepository smsLogRepository;

    @Autowired
    public SMSLogService(SMSLogRepository smsLogRepository) {
        this.smsLogRepository = smsLogRepository;
    }

    public int addToLog(String from, String to, String content, String trackingInfo, boolean delivered, Date sentAt) {

        SMSLog log = new SMSLog();

        log.setSender(from);
        log.setReceiver(to);
        log.setContent(content);
        log.setDelivered(delivered);
        log.setTrackingInfo(trackingInfo);
        log.setSentAt(sentAt);

        return smsLogRepository.save(log).getSmsId();
    }

    public void updateLog(int logID, String trackingInfo, boolean delivered, Date sentAt) {

        Optional<SMSLog> log = smsLogRepository.findById(logID);

        if (log.isPresent()) {

            SMSLog update = log.get();

            update.setSentAt(sentAt);
            update.setDelivered(delivered);
            update.setTrackingInfo(trackingInfo);

            smsLogRepository.save(update);
        }
    }
}
