package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-04 16:57
 * 非终结符表达式。为文法中的非终结符相关的解释操作。
 */
public class NonterminalExpression extends AbstractExpression {


    /**
     * 每个非终结符表达式都会对其他表达式产生依赖
     * @param expression
     */
    public NonterminalExpression(AbstractExpression... expression) {
    }

    @Override
    public Object interpret(Context ctx) {
        return ctx;
    }
}
