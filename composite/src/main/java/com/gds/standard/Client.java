package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-02-13 16:37
 */
public class Client {
    public static void main(String[] args) {
        // 根节点
        Composite root = new Composite();
        root.doSomething();
        // 树枝节点
        Composite branch = new Composite();
        // 叶子节点
        Leaf leaf = new Leaf();
        // 建立整体
        root.add(branch);
        branch.add(leaf);

        display(root);
    }



    public static void display(Composite root) {
        for (Component child : root.getChildren()) {
            if (child instanceof Leaf) {
                child.doSomething();
            } else {
                display((Composite) child);
            }
        }
    }
}
