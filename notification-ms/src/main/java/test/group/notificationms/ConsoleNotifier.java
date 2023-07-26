package test.group.notificationms;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import test.group.basemodels.Order;

@Service
public class ConsoleNotifier implements Notifier{

    @KafkaListener(topics = "eda",groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void announce(Order order) {
        System.out.println("ANNOUNCING ORDER IN CONSOLE" + order.toString());
    }
}
