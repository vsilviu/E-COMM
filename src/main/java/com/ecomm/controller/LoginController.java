package com.ecomm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Silviu on 1/31/16.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
