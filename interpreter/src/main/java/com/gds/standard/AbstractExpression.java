package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-04 16:56
 * 抽象表达式。声明一个抽象的解释操作，该接口为抽象语法树中所有的节点共享
 */
public abstract class AbstractExpression {

    public abstract Object interpret(Context ctx);
}
