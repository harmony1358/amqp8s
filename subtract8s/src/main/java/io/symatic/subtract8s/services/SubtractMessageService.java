package io.symatic.subtract8s.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class SubtractMessageService {

    private final RabbitTemplate rabbitTemplate;
    private final RestTemplate restTemplate;
    private final String exchange;
    private final String routingKey;
    private final String pod;
    private final String redHost;

    @Autowired
    public SubtractMessageService(
            RabbitTemplate rabbitTemplate,
            @Value("${rabbit.exchange}") String exchange,
            @Value("${rabbit.routingKey}") String routingKey,
            @Value("${k8s.pod}") String pod,
            @Value("${red.host}") String redHost) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.pod = pod;
        this.redHost = redHost;
        this.restTemplate = new RestTemplate();
    }

    public void pushSubtractMessage(String msg) {
        log.info("[{}] Pushing subtract message to: {}", pod, routingKey);
        restTemplate.put(redHost + "/counter/increment", null);
        
        // Add a prefix to indicate this is a subtract message
        String subtractMessage = "SUBTRACT:" + msg;
        rabbitTemplate.convertAndSend(exchange, routingKey, subtractMessage);
    }
}
