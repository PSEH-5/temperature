package com.prediction.temperature.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {

    @RequestMapping(value = "/simplyTest" , method = RequestMethod.GET)
    public String test(){
        System.out.println("hello");
        return "helloworld";
    }
}
