package com.gds.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather可以通过实现WeatherObserver接口并注册为监听器来观察。
 * @author zhanglifeng
 * @since 2020-03-16 11:36
 */
public class Weather {

    private WeatherType currentWeather;

    private List<WeatherObserver> observers;

    public Weather() {
        observers = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    /**
     * 事件方法，需要发出通知
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        System.out.println("天气变为：" + currentWeather);
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver ob : observers) {
            ob.update(currentWeather);
        }
    }
}
