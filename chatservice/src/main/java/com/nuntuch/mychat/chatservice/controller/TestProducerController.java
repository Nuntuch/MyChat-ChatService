package com.nuntuch.mychat.chatservice.controller;

import com.nuntuch.mychat.chatservice.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestProducerController {


    @Autowired
    private KafkaProducer kafkaProducer;


    @GetMapping(path = "/test/producer")
    public String testProducer(){

        kafkaProducer.sendMessage("Hello world!!!");

        return "Hello Jabs";
    }

}
