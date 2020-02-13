package com.gds.adapter;

/**
 * @author zhanglifeng
 * @since 2020-01-20 9:52
 */
public class App {
    public static void main(String[] args) {
        Captain captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
}
