package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.model.Person;

@Component
public class KafkaConsumer {

    @KafkaListener(topics ="my-new-topic-1", groupId="my-consumer-group")
    public void listen(Person person){
        System.out.println("Incoming message. " +person);
    }
}
