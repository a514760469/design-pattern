package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-20 11:18
 */
public class Client {

    public static void main(String[] args) {
        Element element = ObjectStructure.createElement();
        element.accept(new ConcreteVisitor());
    }
}
