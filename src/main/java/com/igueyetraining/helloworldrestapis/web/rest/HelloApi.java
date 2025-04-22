package com.igueyetraining.helloworldrestapis.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloApi{


	
    @GetMapping
    public String hello(){
		log.info("hello requested.... ");
        return "Hello World";
    }
	
	
}
