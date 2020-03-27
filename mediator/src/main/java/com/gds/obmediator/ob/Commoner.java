package com.gds.obmediator.ob;

import com.gds.obmediator.Product;

/**
 * @author zhanglifeng
 * @since 2020-03-26 13:13
 */
public class Commoner extends EventConsumer {

    // 平民只处理新建事件
    public Commoner() {
        super(EventConsumerType.NEW);
    }

    @Override
    public void exec(ProductEvent event) {
        Product p = event.getSource();
        ProductEventType type = event.getType();
        System.out.println("平民处理事件：" + p.getName() + "诞生，事件类型：" + type);
    }
}
