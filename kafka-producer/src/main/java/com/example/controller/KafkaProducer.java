package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class KafkaProducer {

    private final KafkaTemplate<String, Person> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Person> kafkaTemplate) {
        System.out.println("TEST");
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Person person) {
        //Person person = new Person("Saminathan", "Govindan", 45);
        kafkaTemplate.send("my-new-topic-1", person);
        return "Message sent :" + person.toString();
    }

}
