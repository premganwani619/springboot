package com.dailycodebuffer.springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController//this annotation means it is a controller(Rest) that returns a response body,component and
public class HelloController {
    @Value("${welcome.message}")

    private String welcomeMessage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHelloMessage() {
        return welcomeMessage;
    }
}
