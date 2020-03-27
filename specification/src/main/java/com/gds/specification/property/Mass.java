package com.gds.specification.property;

/**
 * @author zhanglifeng
 * @since 2020-03-26 15:49
 */
public class Mass {

    private double value;

    private String title;

    public Mass(double value) {
        this.value = value;
        this.title = value + "kg"; // Implicit call to Double.toString(value)
    }

    public final boolean greaterThan(Mass other) {
        return this.value > other.value;
    }

    public final boolean smallerThan(Mass other) {
        return this.value < other.value;
    }

    public final boolean greaterThanOrEq(Mass other) {
        return this.value >= other.value;
    }

    public final boolean smallerThanOrEq(Mass other) {
        return this.value <= other.value;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Mass)) {
            return false;
        }
        return ((Mass) obj).value == this.value;
    }
}
