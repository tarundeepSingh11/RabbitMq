package rabbitMq.rabbitMq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rabbitMq.rabbitMq.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
public class messageController {

    private RabbitMqProducer producer;

    public messageController(RabbitMqProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("message send to rabbitMq....");
    }
}
