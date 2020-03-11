package com.gds.iterator.list;

import com.gds.iterator.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-06 16:10
 */
public class TreasureChest {

    private List<Item> items;

    public TreasureChest() {
        items = Arrays.asList(
                new Item(ItemType.POTION, "勇气药水"),
                new Item(ItemType.RING, "暗影指环"),
                new Item(ItemType.POTION, "智慧药水"),
                new Item(ItemType.POTION, "血药水"),
                new Item(ItemType.WEAPON, "银剑+1"),
                new Item(ItemType.POTION, "腐蚀药水"),
                new Item(ItemType.POTION, "生命药水"),
                new Item(ItemType.RING, "防御指环"),
                new Item(ItemType.WEAPON, "钢戟"),
                new Item(ItemType.WEAPON, "毒药匕首")
        );
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public Iterator<Item> iterator(ItemType type) {
        return new TreasureChestItemIterator(type);
    }


    class TreasureChestItemIterator implements Iterator<Item> {

        private int idx;
        private ItemType type;

        public TreasureChestItemIterator(ItemType type) {
            this.type = type;
            this.idx = -1;
        }

        @Override
        public boolean hasNext() {
            return findNextIdx() != -1;
        }

        @Override
        public Item next() {
            idx = findNextIdx();
            return items.get(idx);
        }

        private int findNextIdx() {
            int tempIdx = idx;
            while (true) {
                tempIdx++;
                if (tempIdx >= items.size()) {
                    tempIdx = -1;
                    break;
                }
                // 找到对应的idx返回
                if (type.equals(ItemType.ANY) || items.get(tempIdx).getType().equals(type)) {
                    break;
                }
            }
            return tempIdx;
        }
    }
}
