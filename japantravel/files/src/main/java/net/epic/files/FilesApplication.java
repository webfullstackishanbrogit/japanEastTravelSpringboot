/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 *
 *
 */

package net.epic.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class Containing MAIN method
 *
 * @author Ayesh Jayasekara
 * @version 1.0.0
 * @apiNote THIS SERVICE REQUIRES MySQL Ver. 8 to support collation used. IF used in lower versions, change collation!
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableSwagger2
@EnableFeignClients
public class FilesApplication {

    public static void main(String[] args) {

        SpringApplication.run(FilesApplication.class, args);

    }
}
