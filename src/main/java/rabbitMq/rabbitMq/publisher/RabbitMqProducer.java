package rabbitMq.rabbitMq.publisher;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import  org.slf4j.Logger;



@Service
public class RabbitMqProducer {
    @Value("${rabbitmq.topicExchange.name}")
    private String topicExchange;
    @Value("${rabbitmq.key.name}")
    private String key;

    private static final Logger LOGGER=LoggerFactory.getLogger(RabbitMqProducer.class);

    private RabbitTemplate rabbitTemplate;
    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("message sent -> %s",message));
        rabbitTemplate.convertAndSend(topicExchange,key,message);
    }

}
