package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-13 14:52
 * 采购
 */
public class Purchase extends AbstractColleague {

    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    public void buyIMBComputer(int number) {
        super.mediator.execute("purchase.buy", number);
    }

    public void refuseBuy() {
        System.out.println("不在采购IBM");
    }
}
