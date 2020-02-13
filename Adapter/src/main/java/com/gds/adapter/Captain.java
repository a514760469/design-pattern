package com.gds.adapter;

/**
 * @author zhanglifeng
 * @since 2020-01-20 9:48
 */
public class Captain {

    private RowingBoat rowingBoat;

    public Captain(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    public void row() {
        rowingBoat.row();
    }
}
