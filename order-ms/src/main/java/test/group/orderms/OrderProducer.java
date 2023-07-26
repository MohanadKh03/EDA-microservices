package test.group.orderms;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import test.group.basemodels.Order;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void makeOrder(Order order){
        Message<Order> message = MessageBuilder
                    .withPayload(order)
                            .setHeader(KafkaHeaders.TOPIC,"eda")
                                    .build();
        kafkaTemplate.send(message);
    }
}
