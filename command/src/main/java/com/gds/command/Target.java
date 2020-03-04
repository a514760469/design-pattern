package com.gds.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 10:40
 */
public abstract class Target {

    private Size size;

    private Visibility visibility;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public abstract String toString();

    public void printStatus() {
        String msg = String.format("%s, [size=%s] [visibility=%s]", this, getSize(), getVisibility());
        System.out.println(msg);
    }
}
