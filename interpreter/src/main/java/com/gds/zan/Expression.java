package com.gds.zan;

import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-03-04 17:49
 * 表达式抽象，包括运算元素、运算符号
 */
public interface Expression {
    /**
     * 解析
     * @param var key: 公式中的参数 value: 具体的数字
     * @return
     */
    int interpret(Map<String, Integer> var);

}
