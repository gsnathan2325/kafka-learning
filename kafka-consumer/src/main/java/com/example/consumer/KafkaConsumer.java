package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics ="my-new-topic", groupId="my-consumer-group")
    public void listen(String message){
        System.out.println("Incoming message" +message);
    }
}
