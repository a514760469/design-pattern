package com.gds.observer;

/**
 * @author zhanglifeng
 * @since 2020-03-16 11:29
 */
public enum WeatherType {

    SUNNY, RAINY, WINDY, COLD;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
