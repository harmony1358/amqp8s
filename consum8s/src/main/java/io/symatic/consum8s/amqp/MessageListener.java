package io.symatic.consum8s.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Listens for messages from the RabbitMQ queue and processes them.
 * 
 * <p>The workflow for this class is to receive a message, retrieve the current hit counter
 * by calling the Red8s service, and log the message along with the counter.</p>
 */
@Slf4j
@Component
public class MessageListener {

    @Value("${k8s.pod}")
    private String pod;

    @Value("${red.host}")
    private String redHost;
    
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Handles the incoming message from the RabbitMQ queue.
     *
     * @param message the message received from the queue.
     */
    @RabbitListener(queues = "${rabbit.queue}")
    public void handleMessage(String message) {
        Integer counter = restTemplate.getForObject(redHost + "/counter/get", Integer.class);
        log.info("[{}] Consuming message: {}, counter {}", pod, message, counter.intValue());
    }

}
