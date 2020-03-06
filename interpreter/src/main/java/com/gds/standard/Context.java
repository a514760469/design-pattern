package com.gds.standard;

import java.util.Stack;

/**
 * @author zhanglifeng
 * @since 2020-03-04 16:58
 * 环境类。包含解释器之外的一些全局信息。
 * 通常是一个封装类，避免了调用者与语法解析器的耦合关系
 */
public class Context {

    private AbstractExpression expression;

    // 通常定一个语法容器，容纳一个具体的表达式，通常为ListArray、LinkedList、Stack等类型
    private Stack<AbstractExpression> stack;

    public Context(String expStr) {
        // 进行语法判断，并产生递归调用
        // 产生一个完整的语法树，由各个具体的语法分析进行解析
        // 具体元素进入场景
    }

    public Object interpreting() {
        return expression.interpret(this);
    }
}
