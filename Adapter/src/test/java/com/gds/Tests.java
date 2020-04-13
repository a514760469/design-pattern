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
    public void testCharArr() {
//        char[] numbers = {'1', '2', '3'};
//        System.out.println(numbers);
//
//        int[] numbers2 = {1, 2, 3};
//        System.out.println(numbers2);

        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println("Animals are equals: " + pig == dog);

        // \u0022 "
        System.out.println("a\u0022.length() + \u0022b".length());
    }


    @Test
    public void browserTest() {
        System.out.print("ie:");
        http://www.google.com
        System.out.println(":maximize");
    }

    @Test
    public void leftMove() {
//        System.out.println(Integer.toBinaryString(-1 << 1));// -2
//        System.out.println(Integer.toBinaryString(-1 >>> 1));//
//        System.out.println(Integer.toBinaryString(-1 >> 1));// -1
//        System.out.println(Integer.toBinaryString(0x7f));
//        double i = 1.0e40;
//        System.out.println(Double.toHexString(i));

//        Integer i = new Integer(1);
//        Integer j = new Integer(1);
//
//        System.out.println(i <= j && j <= i && i != j);

        System.out.println(Integer.toBinaryString(0));
        System.out.println(0xffffffff);

//        System.out.println(i != 0 && i == -i);
    }

    @Test
    public void stackOverFlow() {
        hardWork();
    }

    public void hardWork() {
        try {
            hardWork();
        } finally {
            hardWork();
        }
    }

    @Test
    public void helloWorld() {
        String greeting = "hello world";
        for (int i = 0; i < greeting.length(); i++) {
            System.out.write(greeting.charAt(i));
        }
    }

}
