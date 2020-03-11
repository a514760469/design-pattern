package com.gds.iterator.list;

/**
 * @author zhanglifeng
 * @since 2020-03-06 16:07
 */
public class Item {

    private ItemType type;
    private String name;

    public Item(ItemType type, String name) {
        this.setType(type);
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public final void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}
