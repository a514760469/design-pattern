package com.gds.observer;

import com.gds.observer.generic.GHobbits;
import com.gds.observer.generic.GOrc;
import com.gds.observer.generic.GWeather;

/**
 * @author zhanglifeng
 * @since 2020-03-16 13:35
 */
public class App {

    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();

        System.out.println("---------------------------");
        // 泛型观察者
        GWeather gWeather = new GWeather();
        gWeather.addObserver(new GOrc());
        gWeather.addObserver(new GHobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
    }
}
