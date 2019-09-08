/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 *
 *
 */

package net.epic.files.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Sms", url = "${zuul.url}/smsservice")
public interface SMSClient {

    @RequestMapping(method = RequestMethod.GET, value = "/checkStatus")
    String checkStatus();
}
