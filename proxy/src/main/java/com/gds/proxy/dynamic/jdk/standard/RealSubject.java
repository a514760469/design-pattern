package com.gds.proxy.dynamic.jdk.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 13:26
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething(String str) {
        System.out.println("业务逻辑。doSomething。");
    }
}
