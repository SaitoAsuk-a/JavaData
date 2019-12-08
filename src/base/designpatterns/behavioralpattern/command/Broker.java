package base.designpatterns.behavioralpattern.command;

/**
 * @author liyu
 * @date 2019/12/8 13:57
 * @description ������������ࡣ
 */

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}