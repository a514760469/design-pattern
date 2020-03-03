package com.gds.facade.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 16:34
 */
public class Client {

    public static void main(String[] args) {
        ModernPostOffice office = new ModernPostOffice();
        String ctx = "Hello,It's me,do you know who I am? I'm your old lover. I'd like to...";
        String address = "Happy Road No. 666,God Province,Heave";
        office.sendLetter(ctx, address);

    }
}
