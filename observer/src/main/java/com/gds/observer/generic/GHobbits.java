package com.gds.observer.generic;

import com.gds.observer.WeatherType;

/**
 * @author zhanglifeng
 * @since 2020-03-16 14:01
 */
public class GHobbits implements Race {

    @Override
    public void update(GWeather weather, WeatherType action) {
        switch (action) {
            case COLD:
                System.out.println("Hobbits人在寒冷的天气中瑟瑟发抖。");
                break;
            case RAINY:
                System.out.println("Hobbits人寻找避雨的地方。");
                break;
            case SUNNY:
                System.out.println("幸福的Hobbits人在温暖的阳光下欢歌。");
                break;
            case WINDY:
                System.out.println("在刮风的天气里，霍比特人紧紧地握着他们的帽子。");
                break;
            default:
                break;
        }
    }
}
