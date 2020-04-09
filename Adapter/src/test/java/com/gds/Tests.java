package com.gds;

import org.junit.Test;

/**
 * @author zhanglifeng
 * @since 2020-04-08 17:18
 */
public class Tests {

    public static void main(String[] args) {
        System.out.println(0xcafebabe);
//        String s = Integer.toBinaryString(0xcafebabe);
        long a = 0xcafebabe;
        System.out.println(a);
//        System.out1.println(Integer.toBinaryString(a));
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toHexString(a));


        System.out.println(Integer.toBinaryString(-2));
//        String binaryString = Long.toBinaryString(0xffffffffcafebabeL);
//        System.out1.println(binaryString);

    }

    /**
     * 异或
     * 11111010001
     * 00000010001
     */
    @Test
    public void testSwap() {
        int x = 1984;
        int y = 2001;
//        x ^= y ^= x ^= y;
        System.out.println(Integer.toBinaryString(x));// 11111000000
        System.out.println(Integer.toBinaryString(y));// 11111010001

        x = x ^ y;// x= 10001  = 17
        y = y ^ x;//
        System.out.println(y ^ x);
        x = y ^ x;
        System.out.println("x=" + x + ", y=" + y);
    }


    /**
     *
     */
    @SuppressWarnings("ConstantConditionalExpression")
    @Test
    public void testDosEquis() {
        char x = 'X';
        int i = 0;
        System.out.print(true  ? x : 0);// 第二个和第三个类型不同，如果有int常量则按x的类型输出
        System.out.print(false ? i : x);// 否则按提升类型输出。
    }

    @Test
    public void testBj() {
        Object x = "Buy ";
        String i = "2";
//        x = x + i;
        x += i;
    }

}
