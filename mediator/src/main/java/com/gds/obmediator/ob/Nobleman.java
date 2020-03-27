package com.gds.obmediator.ob;

import com.gds.obmediator.Product;

/**
 * @author zhanglifeng
 * @since 2020-03-26 13:15
 */
public class Nobleman extends EventConsumer {

    public Nobleman() {
        super(EventConsumerType.EDIT, EventConsumerType.CLONE);
    }

    @Override
    public void exec(ProductEvent event) {
        Product p = event.getSource();
        ProductEventType type = event.getType();
        if (type.getValue() == EventConsumerType.CLONE.getValue()) {
            System.out.println("贵族处理事件：" + p.getName() + "克隆，事件类型：" + type);
        } else {
            System.out.println("贵族处理事件：" + p.getName() + "修改，事件类型：" + type);
        }
    }
}
