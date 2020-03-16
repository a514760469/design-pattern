package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-13 15:29
 */
public class Client {

    public static void main(String[] args) {
        AbstractMediator mediator = new Mediator();
        System.out.println("purchase======");
        Purchase purchase = new Purchase(mediator);
        purchase.buyIMBComputer(10);

        System.out.println("sale=======");
        Sale sale = new Sale(mediator);
        sale.sellIBMComputer(5);

        System.out.println("stock======");
        Stock stock = new Stock(mediator);
        stock.clearStock();

    }
}
