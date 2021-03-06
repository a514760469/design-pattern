package com.gds.zan;

import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-03-04 17:52
 * 减法运算
 */
public class SubExpression extends SymbolExpression {
    /**
     * 只关心左右两个表达式的结果
     *
     * @param left
     * @param right
     */
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret(Map<String, Integer> var) {
        return left.interpret(var) - right.interpret(var);
    }
}
