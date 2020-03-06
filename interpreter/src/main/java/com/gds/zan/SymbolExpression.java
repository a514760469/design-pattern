package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-04 17:51
 * 运算符号 + - * /
 */
public abstract class SymbolExpression implements Expression {

    protected Expression left;

    protected Expression right;

    /**
     * 只关心左右两个表达式的结果
     */
    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
