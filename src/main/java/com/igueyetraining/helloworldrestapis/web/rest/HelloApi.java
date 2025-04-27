package com.igueyetraining.helloworldrestapis.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloApi {
	
	@Autowired
	BuildProperties buildProperties;

    @GetMapping("/hello")
    public String hello(){
		log.info("hello requested.... ");
        return "Hello World [" + buildProperties.getName() + ":" + buildProperties.getVersion() + "]";
    }
}
