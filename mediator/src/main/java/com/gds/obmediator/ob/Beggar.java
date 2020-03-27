package com.gds.obmediator.ob;

import com.gds.obmediator.Product;

/**
 * @author zhanglifeng
 * @since 2020-03-26 13:09
 */
public class Beggar extends EventConsumer {

    // 乞丐只能处理被遗弃的东西
    public Beggar() {
        super(EventConsumerType.DEL);
    }

    @Override
    public void exec(ProductEvent event) {
        Product p = event.getSource();
        ProductEventType type = event.getType();
        System.out.println("乞丐处理事件：" + p.getName() + "销毁，事件类型：" + type);
    }
}
