package test.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.kafka.service.KafkaProducer;

/**
 *
 */
@Controller
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaProducer producer;

    @Autowired
    KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @GetMapping
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);

        return "success";
    }
}
