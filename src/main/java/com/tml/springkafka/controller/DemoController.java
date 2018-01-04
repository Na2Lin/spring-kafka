package com.tml.springkafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("send")
    public String demoTest() {
        Map message = new HashMap();
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic1", message.toString());
        System.out.println(future);
        return "success";
    }
}
