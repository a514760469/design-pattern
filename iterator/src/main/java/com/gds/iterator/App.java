package com.gds.iterator;

import com.gds.iterator.bst.BstIterator;
import com.gds.iterator.bst.TreeNode;
import com.gds.iterator.list.Item;
import com.gds.iterator.list.ItemType;
import com.gds.iterator.list.TreasureChest;

import static com.gds.iterator.list.ItemType.*;

/**
 * @author zhanglifeng
 * @since 2020-03-06 18:45
 */
public class App {

    private static final TreasureChest TREASURE_CHEST = new TreasureChest();

    private static void demonstrateTreasureChestIteratorForType(ItemType itemType) {
        System.out.println("-----------------------------------------------");
        System.out.println("Item Iterator for ItemType " + itemType + ": ");
        Iterator<Item> iterator = TREASURE_CHEST.iterator(itemType);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    private static TreeNode<Integer> buildIntegerBst() {
        TreeNode<Integer> root = new TreeNode<>(8);
        root.insert(3);
        root.insert(10);
        root.insert(1);
        root.insert(6);
        root.insert(14);
        root.insert(4);
        root.insert(7);
        root.insert(13);
        System.out.println("Tree Root: " + root);
        return root;
    }

    private static void demonstrateBstIterator() {
        System.out.println("BST Iterator: ");
        TreeNode<Integer> root = buildIntegerBst();
        BstIterator<Integer> bstIterator = new BstIterator<>(root);
        while (bstIterator.hasNext()) {
            System.out.println("Next Node: " + bstIterator.next().getVal());
        }
    }


    public static void main(String[] args) {
//        demonstrateTreasureChestIteratorForType(RING);
//        demonstrateTreasureChestIteratorForType(POTION);
//        demonstrateTreasureChestIteratorForType(WEAPON);
//        demonstrateTreasureChestIteratorForType(ANY);

        demonstrateBstIterator();
    }
}
