package com.soloworld.kafka.straem.demo.controller;

import com.soloworld.kafka.straem.demo.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaControler {

    private KafkaService kafkaService;

    public KafkaControler(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("/post/{message}")
    public  String postMessage(@PathVariable String message) {
        return kafkaService.addTopicToBroker(message);
    }
}
