package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-04 16:56
 * 终结符表达式。实现与文法中的终结符相关的解释操作。
 * 实现抽象表达式中所要求的方法。
 * 文法中每一个终结符都有一个具体的终结表达式与之相对应
 */
public class TerminalExpression extends AbstractExpression {


    @Override
    public Object interpret(Context ctx) {
        return ctx;
    }
}
