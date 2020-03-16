package com.gds.zan;

import java.util.Random;

/**
 * @author zhanglifeng
 * @since 2020-03-13 14:53
 * 销售
 */
public class Sale extends AbstractColleague {

    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    public void sellIBMComputer(int number) {
        mediator.execute("sale.sell", number);
        System.out.println("销售：" + number);
    }

    public int getSellStatus() {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("销售情况为：" + saleStatus);
        return saleStatus;
    }

    public void offSale() {
        mediator.execute("sale.offSale");
    }
}
