package com.basic.docker.compose.example.infra.spring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@CrossOrigin(origins = "*")
public class Hello {

    @GetMapping("hello")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        return "Hello!!!";
    }


}
