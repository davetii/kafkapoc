package com.greatwideweb.kafkapoc.controller;

import com.greatwideweb.kafkapoc.producer.ProducerKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    Environment env;

    @Autowired
    ProducerKafka producerKafka;

    @RequestMapping(value = "/helloworld")
    public String getResponse(@RequestParam("m") String m) {
        producerKafka.sendMessage(m);
        return m;
    }
}
