package com.gds.zan;

import java.util.HashMap;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:46
 */
public class SignFactory {

    private static HashMap<String, SignInfo> pool = new HashMap<>();

    @Deprecated
    public static SignInfo getSignInfo() {
        return new SignInfo();
    }

    public static SignInfo getSignInfo(String key) {
        // 设置返回对象
        SignInfo result;
        // 池中没有该对象，则建立，并放入池中
        if (!pool.containsKey(key)){
            System.out.println(key + "----建立对象，并放置到池中");
            result = new SignInfo4Pool(key);
            pool.put(key, result);
        } else {
            result = pool.get(key);
            System.out.println(key + "---直接从池中取得");
        }
        return result;
    }
}
