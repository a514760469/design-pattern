package com.gds.observer;

/**
 * @author zhanglifeng
 * @since 2020-03-16 11:33
 */
public class Orcs implements WeatherObserver {


    @Override
    public void update(WeatherType type) {
        switch (type) {
            case COLD:
                System.out.println("兽人冷得要命。");
                break;
            case RAINY:
                System.out.println("兽人浑身湿透了。");
                break;
            case SUNNY:
                System.out.println("太阳闪耀着兽人的眼睛。");
                break;
            case WINDY:
                System.out.println("兽人的气味几乎在风中消失。");
                break;
            default:
                break;
        }
    }
}
