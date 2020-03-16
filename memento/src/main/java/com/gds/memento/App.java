package com.gds.memento;

import com.gds.BeanUtils;
import com.gds.memento.Star.StarMemento;

import java.util.Map;
import java.util.Stack;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:45
 */
public class App {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Stack<StarMemento> stack = new Stack<>();
        Star star = new Star(StarType.SUN, 10000000, 500000);
        Map<String, Object> backupProp = BeanUtils.backupProp(star);
        System.out.println("backupProp: " + backupProp);
        Star restoreStar = new Star(null, 0, 0);
        BeanUtils.restoreProp(restoreStar, backupProp);
        System.out.println("restoreStar: " + restoreStar);

        System.out.println("-----------------------------");

        System.out.println(star);

        stack.add(star.getMemento());
        star.timePasses();
        System.out.println(star);

        stack.add(star.getMemento());
        star.timePasses();
        System.out.println(star);

        stack.add(star.getMemento());
        star.timePasses();
        System.out.println(star);

        stack.add(star.getMemento());
        star.timePasses();
        System.out.println(star);

        stack.add(star.getMemento());
        star.timePasses();
        System.out.println(star);


        while (!stack.isEmpty()) {
            star.setMemento(stack.pop());
            System.out.println(star);
        }
    }



}
