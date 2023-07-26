package test.group.orderms;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.group.basemodels.Order;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String makeOrder(@RequestBody Order order){
        orderProducer.makeOrder(order);
        return "Order placed successfully!";
    }

}
