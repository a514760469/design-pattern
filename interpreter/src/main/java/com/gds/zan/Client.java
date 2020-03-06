package com.gds.zan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-03-04 17:54
 */
public class Client {

    public static void main(String[] args) {
        Calculator calculator = new Calculator("a+b-c+d");
        Map<String, Integer> var = new HashMap<>();
        var.put("a", 1);
        var.put("b", 3);
        var.put("c", 4);
        var.put("d", 4);
        int res = calculator.run(var);
        System.out.println(res);
    }

}
