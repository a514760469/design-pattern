package com.gds.observer.generic;

import com.gds.observer.WeatherType;

/**
 * @author zhanglifeng
 * @since 2020-03-16 13:57
 */
public class GWeather extends Observable<GWeather, Race, WeatherType> {

    private WeatherType currentWeather;

    public GWeather() {
        this.currentWeather = WeatherType.SUNNY;
    }

    /**
     * 事件方法，需要发出通知
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        System.out.println("天气变为：" + currentWeather);
        notifyObservers(currentWeather);
    }

}
