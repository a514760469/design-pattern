package com.gds.observer.generic;

import com.gds.observer.WeatherType;

/**
 * @author zhanglifeng
 * @since 2020-03-16 14:01
 */
public class GOrc implements Race {

    @Override
    public void update(GWeather weather, WeatherType action) {
        switch (action) {
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
