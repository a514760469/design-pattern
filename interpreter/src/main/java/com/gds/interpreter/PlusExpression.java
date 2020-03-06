package com.gds.interpreter;

/**
 * @author zhanglifeng
 * @since 2020-03-05 11:57
 */
public class PlusExpression extends Expression {

    private Expression left;

    private Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }

    @Override
    public String toString() {
        return "+";
    }
}
