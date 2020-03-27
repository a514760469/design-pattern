package com.gds.obmediator.ob;

/**
 * @author zhanglifeng
 * @since 2020-03-25 18:00
 */
public enum ProductEventType {

    NEW_PRODUCT(1),
    DEL_PRODUCT(2),
    EDIT_PRODUCT(3),
    CLONE_PRODUCT(4);

    private int value = 0;

    ProductEventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
