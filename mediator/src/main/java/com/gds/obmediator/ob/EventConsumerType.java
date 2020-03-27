package com.gds.obmediator.ob;

/**
 * @author zhanglifeng
 * @since 2020-03-26 11:30
 */
public enum EventConsumerType {

    NEW(1), DEL(2), EDIT(3), CLONE(4);

    private int value;

    EventConsumerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
