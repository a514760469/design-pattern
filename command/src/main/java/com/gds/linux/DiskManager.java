package com.gds.linux;

/**
 * @author zhanglifeng
 * @since 2020-03-23 18:18
 */
public class DiskManager {

    /**
     * 默认计算大小
     */
    public static String df() {
        return "/\t10485760\n/usr\t104857600\n/home\t1048576000\n";
    }

    /**
     * kb计算
     */
    public static String df_k() {
        return "/\t10240\n/usr\t102400\n/home\tt10240000\n";
    }

    /**
     * gb计算
     */
    public static String df_g() {
        return "/\t10\n/usr\t100\n/home\tt10000\n";
    }
}
