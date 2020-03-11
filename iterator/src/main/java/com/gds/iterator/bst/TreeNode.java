package com.gds.iterator.bst;

/**
 * @author zhanglifeng
 * @since 2020-03-09 15:18
 * 表示二叉搜索树中的一个节点
 */
public class TreeNode<T extends Comparable<T>> {

    private T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Creates a TreeNode with a given value, and null children.
     *
     * @param val The value of the given node
     */
    public TreeNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    private void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    private void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     *
     * @param valueToInsert 要作为新TreeNode插入的值
     */
    public void insert(T valueToInsert) {
        TreeNode<T> parent = getParentNodeOfValueToBeInserted(valueToInsert);
        parent.insertNewChild(valueToInsert);
    }

    /**
     * 获取要插入到BST中的给定值的父TreeNode。
     * @param valToInsert 要作为新TreeNode插入的值
     * @return 父节点
     */
    private TreeNode<T> getParentNodeOfValueToBeInserted(T valToInsert) {
        TreeNode<T> parent = null;
        TreeNode<T> curr = this;

        while (curr != null) {
            parent = curr;
            curr = curr.traverseOneLevelDown(valToInsert);
        }
        return parent;
    }

    /**
     * 向下移动一层
     * @param value 将插入当前节点下面的TreeNode的值
     * @return 当前节点的子TreeNode，它表示将插入' value '的子树
     */
    private TreeNode<T> traverseOneLevelDown(T value) {
        if (this.isGreaterThan(value)) {
            return this.left;
        } else {
            return this.right;
        }
    }

    private boolean isGreaterThan(T val) {
        return this.val.compareTo(val) > 0;
    }

    private boolean isLessThanOrEquals(T val) {
        return this.val.compareTo(val) < 1;
    }

    /**
     * 将给定值的新子TreeNode添加到树上。
     * 警告:这个方法是破坏性的(将覆盖现有的树结构，如果有的话)，应该只被这个类的insert()方法调用。
     * @param val 要插入的新TreeNode的值
     */
    private void insertNewChild(T val) {
        if (this.isLessThanOrEquals(val)) {
            this.setRight(new TreeNode<>(val));
        } else {
            this.setLeft(new TreeNode<>(val));
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
