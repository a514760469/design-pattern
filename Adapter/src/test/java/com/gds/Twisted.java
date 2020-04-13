package com.gds;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zhanglifeng
 * @since 2020-04-13 10:20
 */
public class Twisted {

    private final String name;

    Twisted (String name) {
        this.name = name;
    }

    private String name() {
        return name;
    }

    private void reproduce() {
        new Twisted("reproduce") {
            void printName() {
                System.out.println(name());
            }
        }.printName();
    }

    public static void main(String[] args) {
//        new Twisted("main").reproduce();
        Integer[] array = {3, 1, 4, 1, 5, 9};
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? - 1 : 0;
            }
        });
        System.out.println(Arrays.toString(array));
    }

}
