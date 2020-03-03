package com.gds.facade.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-02 16:42
 */
public class Facade {

    private SubSystemA a = new SubSystemA();
    private SubSystemB b = new SubSystemB();
    private SubSystemC c = new SubSystemC();

    public void method1() {
        a.doSomeThingA();
    }

    public void method2() {
        b.doSomeThingB();
    }

    public void method3() {
        c.doSomeThingC();
    }
}
