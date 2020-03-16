package com.gds.observer;

/**
 * @author zhanglifeng
 * @since 2020-03-16 11:29
 */
public interface WeatherObserver {

    void update(WeatherType type);
}
