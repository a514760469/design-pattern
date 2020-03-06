package com.gds.zan;

import java.util.Map;
import java.util.Stack;

/**
 * @author zhanglifeng
 * @since 2020-03-04 17:54
 */
public class Calculator {

    private Expression expression;

    /**
     * a + b - c
     * @param expStr 表达式
     */
    public Calculator(String expStr) {

        Stack<Expression> stack = new Stack<>();

        Expression left;
        Expression right;
        // 表达式拆分为字符数组
        char[] chars = expStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '+' :
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-' :
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    // 创建运算元素表达式，入栈
                    stack.push(new VarExpression(String.valueOf(chars[i])));
            }
        }
        this.expression = stack.pop();
    }


    public int run(Map<String, Integer> var) {
        return expression.interpret(var);
    }

}
