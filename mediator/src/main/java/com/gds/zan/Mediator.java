package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-13 14:57
 */
public class Mediator extends AbstractMediator {

    @Override
    public void execute(String str, Object... objects) {
        switch (str) {
            case "purchase.buy" :
                this.buyComputer((Integer) objects[0]);
                break;
            case "sale.sell" :
                this.saleComputer((Integer) objects[0]);
                break;
            case "sale.offSale" :
                this.offSell();
                break;
            case "stock.clear" :
                this.clearStock();
                break;
        }
    }

    /**
     * 采购电脑
     * @param number
     */
    private void buyComputer(int number) {
        int sellStatus = sale.getSellStatus();

        if (sellStatus > 80) {
            System.out.println("采购电脑" + number + "台");
            stock.increase(number);
        } else {
            int buyNumber = number / 2;
            System.out.println("采购电脑" + buyNumber + "台");
            stock.increase(buyNumber);
        }
    }

    /**
     * 销售电脑
     * @param number
     */
    private void saleComputer(int number) {
        if (stock.getComputerNumber() < number) {
            // 库存数量不够
            purchase.buyIMBComputer(number);
        }
        stock.decrease(number);
    }

    /**
     * 折价销售
     */
    private void offSell() {
        System.out.println("折价销售" + stock.getComputerNumber() + "台");
    }

    /**
     * 清仓处理
     */
    private void clearStock() {
        sale.offSale();
        purchase.refuseBuy();
    }
}
