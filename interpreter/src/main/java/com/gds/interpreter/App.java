package com.gds.interpreter;

import java.util.Stack;

/**
 * @author zhanglifeng
 * @since 2020-03-05 13:05
 */
public class App {

    public static void main(String[] args) {
        String tokenString = "4 3 2 - 1 + *";
        Stack<Expression> stack = new Stack<>();

        String[] tokenArr = tokenString.split(" ");
        for (String s : tokenArr) {
            if (isOperator(s)) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                System.out.println("popped from stack left: " + left.interpret() + " right: " + right.interpret());
                Expression operator = getOperatorInstance(s, left, right);
                System.out.println("operator: " + operator);
                NumberExpression result = new NumberExpression(operator.interpret());
                stack.push(result);
                System.out.println("push result to stack: " + result.interpret());
            } else {
                NumberExpression result = new NumberExpression(s);
                stack.push(result);
                System.out.println("push to stack: " + result.interpret());
            }
        }
        System.out.println("result: " + stack.pop().interpret());

    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
            default:
                return new MultiplyExpression(left, right);
        }
    }
}
