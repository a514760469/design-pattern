package com.gds.obmediator;

import com.gds.obmediator.ob.Beggar;
import com.gds.obmediator.ob.Commoner;
import com.gds.obmediator.ob.EventDispatcher;
import com.gds.obmediator.ob.Nobleman;

/**
 * @author zhanglifeng
 * @since 2020-03-26 13:26
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        EventDispatcher dispatcher = EventDispatcher.getDispatcher();
        dispatcher.registerCustomer(new Beggar());
        dispatcher.registerCustomer(new Commoner());
        dispatcher.registerCustomer(new Nobleman());

        ProductManager factory = new ProductManager();
        // 制造一个产品
        System.out.println("=====模拟创建产品事件========");
        System.out.println("创建一个叫做小男孩的原子弹");
        Product p = factory.createProduct("小男孩");
        System.out.println("\n=====模拟修改产品事件========");
        System.out.println("把小男孩原子弹修改为胖子号原子弹");
        factory.editProduct(p, "大男孩");
        System.out.println("\n=====模拟克隆产品事件========");
        System.out.println("克隆胖子号原子弹");
        factory.clone(p);
        System.out.println("\n=====模拟销毁产品事件========");
        System.out.println("遗弃胖子号原子弹");
        factory.abandonProduct(p);
    }
}
