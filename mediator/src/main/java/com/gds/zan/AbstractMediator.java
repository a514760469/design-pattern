package com.gds.zan;


/**
 * @author zhanglifeng
 * @since 2020-03-13 14:51
 */
public abstract class AbstractMediator {

    protected Purchase purchase;

    protected Sale sale;

    protected Stock stock;

    public AbstractMediator() {
        this.purchase = new Purchase(this);
        this.sale = new Sale(this);
        this.stock = new Stock(this);
    }

    /**
     * 中介者最重要的方法，事件方法，处理多个对象之间的关系
     * @param str
     * @param objects
     */
    public abstract void execute(String str, Object... objects);

}
