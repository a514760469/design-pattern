package com.gds.proxy.dynamic.jdk.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 16:02
 */
public class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        System.out.println("前置通知被执行");
    }
}
