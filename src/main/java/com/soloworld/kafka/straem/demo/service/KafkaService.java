package com.soloworld.kafka.straem.demo.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaService {

    private NewTopic topic;
    private KafkaTemplate<String,String> template;


    public KafkaService(NewTopic topic, KafkaTemplate<String, String> template) {
        this.topic = topic;
        this.template = template;
    }


    public String addTopicToBroker(String message) {
        CompletableFuture<SendResult<String, String>> send = template.send(topic.name(), message);
        try {
            SendResult<String, String> stringStringSendResult = send.get();
           return stringStringSendResult.getProducerRecord().value();
        } catch (Exception e) {
            return "cant post topic"+ e.getMessage();
        }



    }
}
