package test.group.notificationms;

import test.group.basemodels.Order;

public interface Notifier {
    void announce(Order order);
}
