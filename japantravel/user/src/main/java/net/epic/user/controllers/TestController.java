package net.epic.user.controllers;

import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller for checking functional status manually
 *
 * @author Ayesh Jayasekara
 * @version 1 (7/25/2019)
 */
@RestController
public class TestController {

    @Autowired
    AccessToken accessToken;

    @Autowired
    AccessToken.Access access;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return accessToken.getEmail();
    }
}
