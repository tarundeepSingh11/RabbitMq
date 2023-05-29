package rabbitMq.rabbitMq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rabbitMq.rabbitMq.dto.User;
@Service
public class RabbitMqJsonProducer {
    @Value("${rabbitmq.topicExchange.name}")
    private String topicExchange;

    @Value("${rabbitmq.key.json.name}")
    private String jsonKey;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMqJsonProducer.class);
    private RabbitTemplate rabbitTemplate;
    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(User user){
        LOGGER.info(String.format("message sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(topicExchange,jsonKey,user);
    }

}
