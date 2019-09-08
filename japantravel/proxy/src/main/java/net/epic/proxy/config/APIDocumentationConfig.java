/*
 * Copyright (c) 2019.
 * This is a property of Epic Lanka Technologies Pvt. Ltd.
 * Any unauthorized reproduction is strictly prohibited.
 * All Rights Reserved.
 * Author: Ayesh Jayasekara (ayesh_j@epiclanka.net)
 *
 *
 */

package net.epic.proxy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration class for Swagger API documentation accumulations using swagger plugin.
 * Note that swagger enabling on each module is explicitly required and must not conflict with security configuration.
 *
 * @author Ayesh Jayasekra
 * @version 1.0.0
 * @since Ver. 1.0.0
 */
@Configuration
@EnableSwagger2
@Primary
public class APIDocumentationConfig implements SwaggerResourcesProvider {

    /**
     * Zuul Routes Locator
     */
    private RouteLocator routeLocator;

    /**
     * Spring autowired dependency for dependency injection
     *
     * @param routeLocator Zuul Route Locator to fetch registered routes
     */
    @Autowired
    public APIDocumentationConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    /**
     * Creates a REST API for Swagger
     *
     * @param isEnabled Property configuration to enable and disable swagger for security purposes
     * @return Docket Object with API Information
     */
    @Bean
    public Docket createRestApi(@Value("${swagger.enabled}") boolean isEnabled) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(isEnabled).select()
                .apis(RequestHandlerSelectors.basePackage("net.epic"))
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    /**
     * Build Basic API Information
     *
     * @return ApiInfo object for SwaggerAPI
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Routing Gateway(Zuul): API DOCUMENTATION OF JAPAN EAST TRAVEL SITE")
                .description("Japan East Travel : Epic Lanka Technologies Pvt. Ltd.")
                .contact(new Contact("Ayesh Jayasekara", "https://www.ayeshj.online/",
                        "ayesh_j@epiclanka.net"))
                .version("1.0.0")
                .termsOfServiceUrl("https://epiclanka.net")
                .build();
    }

    /**
     * Fetch All documentations for each endpoint registered with Eureka and thus with Zuul
     *
     * @return List of swagger API resources
     */
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
//        resources.add(swaggerResource("proxyServer", "/v2/api-docs", "2.0")); Disabled since no API are present on Proxy Server itself
        routeLocator.getRoutes().forEach(route -> resources.add(swaggerResource(route.getId(),
                route.getFullPath().replace("**", "v2/api-docs"),
                "2.0")));

        return resources;
    }

    /**
     * Build the Swagger Resource object
     *
     * @param name     name of the service
     * @param location path to the service
     * @param version  Swagger version used (defaults to 2.0.0)
     * @return Swagger resource for service
     */
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
