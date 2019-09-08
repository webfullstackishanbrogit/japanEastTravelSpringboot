/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 */

package net.epic.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Application initiator class containing main method.
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@RefreshScope
public class EmailApplication {

    /**
     * Default main method of the boot application
     *
     * @param args Command line arguments passed to the boot application
     */
    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

}
