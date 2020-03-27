package com.gds.obmediator.ob;

import com.gds.obmediator.Product;

import java.util.Observable;

/**
 * 事件。可被观察
 * @author zhanglifeng
 * @since 2020-03-25 18:01
 */
public class ProductEvent extends Observable {

    /**
     * 时间源
     */
    private Product source;
    /**
     * 事件类型
     */
    private ProductEventType type;

    public ProductEvent(Product source) {
        this(source, ProductEventType.NEW_PRODUCT);
    }

    public ProductEvent(Product source, ProductEventType type) {
        this.source = source;
        this.type = type;
        notifyEventDispatcher();
    }

    public Product getSource() {
        return source;
    }

    public ProductEventType getType() {
        return type;
    }

    private void notifyEventDispatcher() {
        super.addObserver(EventDispatcher.getDispatcher());
        super.setChanged();
        super.notifyObservers(source);
    }
}
