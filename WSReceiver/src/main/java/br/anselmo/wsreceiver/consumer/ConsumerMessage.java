package br.anselmo.wsreceiver.consumer;

import br.anselmo.wsreceiver.domain.StringResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMessage {
    @RabbitListener(queues = "linkExtractor.queue")
    public void consumer(StringResponse message) {
        System.out.println(message.getResponse());
    }
}
