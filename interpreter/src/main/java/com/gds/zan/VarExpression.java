package com.gds.zan;

import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-03-04 17:50
 * 运算元素  a b c d
 */
public class VarExpression implements Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     *
     * @param var key: a b c value: 具体的数字 1 2 5
     * @return
     */
    @Override
    public int interpret(Map<String, Integer> var) {
        return var.get(key);
    }
}
