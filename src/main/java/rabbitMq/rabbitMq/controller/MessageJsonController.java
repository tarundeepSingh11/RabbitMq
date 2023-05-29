package rabbitMq.rabbitMq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rabbitMq.rabbitMq.dto.User;
import rabbitMq.rabbitMq.publisher.RabbitMqJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    @Autowired
    private RabbitMqJsonProducer rabbitMqJsonProducer;

    @PostMapping("/publish2")
    public ResponseEntity<String> sendMessage(@RequestBody User user){
        rabbitMqJsonProducer.sendMessage(user);
        return ResponseEntity.ok("message send to rabbitMq....");
    }
}
