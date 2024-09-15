package com.nuntuch.mychat.chatservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "my-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic ,String message) {
        System.out.println("Producing message: " + message);
        kafkaTemplate.send(topic, message);
    }
}
