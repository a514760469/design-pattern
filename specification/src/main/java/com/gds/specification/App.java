package com.gds.specification;

import com.gds.specification.creature.*;
import com.gds.specification.property.Color;
import com.gds.specification.property.Movement;
import com.gds.specification.selector.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanglifeng
 * @since 2020-03-27 16:32
 */
public class App {

    public static void main(String[] args) {
        List<Creature> creatures = Arrays.asList(new Goblin(), new Octopus(),
                new Dragon(), new Shark(), new Troll(), new KillerBee());

        // 找到所有 移动方式为 WALKING 的生物
        List<Creature> walkingCreatures = creatures.stream().filter(new MovementSelector(Movement.WALKING)).collect(Collectors.toList());
        walkingCreatures.forEach(System.out::println);
        System.out.println();

        // 颜色为 dark 的生物
        List<Creature> darkCreatures = creatures.stream().filter(new ColorSelector(Color.DARK)).collect(Collectors.toList());
        darkCreatures.forEach(System.out::println);
        System.out.println();

        // 找到所有超过600公斤的生物
        List<Creature> heavyCreatures = creatures.stream().filter(new MassGreaterThanSelector(600D)).collect(Collectors.toList());
        heavyCreatures.forEach(System.out::println);
        System.out.println();

        // 找到所有重量小于或正好500公斤的生物
        List<Creature> less500 = creatures.stream().filter(new MassSmallerThanOrEqSelector(500D)).collect(Collectors.toList());
        less500.forEach(System.out::println);
        System.out.println();

        // 红色会飞的生物
        System.out.println("红色会飞的生物");
        List<Creature> redAndFlyingCreatures = creatures.stream()
                .filter(new ColorSelector(Color.RED).and(new MovementSelector(Movement.FLYING)))
                .collect(Collectors.toList());
        redAndFlyingCreatures.forEach(System.out::println);

        // 找到所有黑色或红色、不会游泳、体重大于或等于400公斤的生物
        System.out.println("\n恐怖生物");
        AbstractSelector<Creature> selector = new ColorSelector(Color.RED)
                .or(new ColorSelector(Color.DARK))
                .and(new MovementSelector(Movement.SWIMMING).not())
                .and(new MassGreaterThanSelector(400.0).or(new MassEqualsSelector(400.0)));
        List<Creature> scaryCreatures = creatures.stream().filter(selector).collect(Collectors.toList());

        scaryCreatures.forEach(System.out::println);
    }
}
