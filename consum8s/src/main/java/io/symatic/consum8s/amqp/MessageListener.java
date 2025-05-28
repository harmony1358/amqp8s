package io.symatic.consum8s.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class MessageListener {

    @Value("${k8s.pod}")
    private String pod;

    @Value("${red.host}")
    private String redHost;
    private RestTemplate restTemplate = new RestTemplate();

    @RabbitListener(queues = "${rabbit.queue}")
    public void handleMessage (String message) {

        Integer counter = restTemplate.getForObject(redHost + "/counter/get", Integer.class);
        log.info("[{}] Consuming message: {}, counter {}", pod, message, counter.intValue());
        log.warn("[{}] Consuming message: {}, counter {}", pod, message, counter.intValue());

    }

}
