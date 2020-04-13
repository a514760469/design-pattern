package com.gds;

/**
 * 出现死锁！
 * @author zhanglifeng
 * @since 2020-04-10 18:34
 */
public class Lazy {

    private static boolean initial = false;

    static {
        // 在类的初始化期间等待某个后台线程很可能会造成死锁
        Thread t = new Thread(() -> initial = true);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(initial);
    }
}
