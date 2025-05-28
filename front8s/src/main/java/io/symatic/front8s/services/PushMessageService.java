package io.symatic.front8s.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service for pushing messages.
 * 
 * <p>This service handles the workflow of logging the push action, incrementing the counter via a REST call,
 * and sending the message through RabbitMQ.</p>
 */
@Slf4j
@Service
public class PushMessageService {

    @Value("${rabbit.routingKey}")
    private String routingKey;

    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${k8s.pod}")
    private String pod;

    @Value("${red.host}")
    private String redHost;

    private RabbitTemplate rabbitTemplate;
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Constructor for PushMessageService.
     *
     * @param rabbitTemplate the RabbitTemplate used to send messages.
     */
    @Autowired
    public PushMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Pushes a message by making a REST call to increment a counter and then sending the message to RabbitMQ.
     *
     * @param msg the message to be pushed.
     */
    public void pushMessage(String msg) {
        log.info("[{}] Pushing message to: {}", pod, routingKey);
        restTemplate.put(redHost + "/counter/increment", null);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
    }

}
