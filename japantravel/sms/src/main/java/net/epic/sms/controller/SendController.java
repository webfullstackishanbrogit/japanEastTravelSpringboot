/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 *
 *
 */

package net.epic.sms.controller;

import net.epic.sms.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    private SMSService smsService;

    @Autowired
    public SendController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public String sendSMS(@RequestParam("from") String from,
                          @RequestParam("to") String to,
                          @RequestParam("content") String content) {
        return smsService.sendSMS(from, to, content);
    }

    @GetMapping("/checkStatus")
    public String checkStatus() {
        return "SENT";
    }
}
