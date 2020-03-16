package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-13 14:53
 * 库存
 */
public class Stock extends AbstractColleague {
    /** 刚开始100台 */
    private static int COMPUTER_NUMBER = 100;

    public Stock(AbstractMediator mediator) {
        super(mediator);
    }

    public void increase(int number) {
        COMPUTER_NUMBER += number;
        System.out.println("库存数量为：" + COMPUTER_NUMBER);
    }

    public void decrease(int number) {
        COMPUTER_NUMBER -= number;
        System.out.println("库存数量为：" + COMPUTER_NUMBER);
    }

    public int getComputerNumber() {
        return COMPUTER_NUMBER;
    }

    public void clearStock() {
        System.out.println("清理存货数量为："+COMPUTER_NUMBER);
        mediator.execute("stock.clear");
    }
}
