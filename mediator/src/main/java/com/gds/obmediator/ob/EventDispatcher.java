package com.gds.obmediator.ob;

import com.gds.obmediator.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 事件观察者
 * 事件分发者 （Dispatch 分发） 分发事件，并同时协调各个同事类（也就是事件的处理者）处理事件
 * 事件处理者的管理员角色
 * @author zhanglifeng
 * @since 2020-03-25 17:59
 */
public class EventDispatcher implements Observer {

    private final static EventDispatcher DISPATCHER = new EventDispatcher();

    private List<EventConsumer> eventConsumers = new ArrayList<>();

    private EventDispatcher() {
    }

    public static EventDispatcher getDispatcher() {
        return DISPATCHER;
    }

    /**
     * 处理事件的update方法
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        Product product = (Product) arg;
        ProductEvent event = (ProductEvent) o;
        for (EventConsumer consumer : eventConsumers) {
            for (EventConsumerType type : consumer.getTypes()) {
                if (type.getValue() == event.getType().getValue()) {
                    consumer.exec(event);
                }
            }
        }
    }

    public void registerCustomer(EventConsumer consumer) {
        eventConsumers.add(consumer);
    }
}
