package com.ewangz.javaarchitecture.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aaronqin on 16/3/18.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
