package com.gds.state;

/**
 * @author zhanglifeng
 * @since 2020-03-16 15:50
 */
public class App {

    public static void main(String[] args) {
        Mammoth mammoth = new Mammoth();
        mammoth.observe();

        mammoth.timePassed();
        mammoth.observe();

        mammoth.timePassed();
        mammoth.observe();
    }
}
