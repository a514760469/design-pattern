package com.gds.iterator.bst;

import com.gds.iterator.Iterator;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

/**
 * @author zhanglifeng
 * @since 2020-03-10 10:54
 */
public class BstIterator<T extends Comparable<T>> implements Iterator<TreeNode<T>> {

    private ArrayDeque<TreeNode<T>> pathStack;

    public BstIterator(TreeNode<T> root) {
        this.pathStack = new ArrayDeque<>();
        pushPathToNextSmallest(root);
    }

    /**
     * 它在处理当前节点或right节点之前，通过维护要处理的节点栈(首先push所有左子节点)。
     * 左根右
     * @param node 我们感兴趣的根
     */
    private void pushPathToNextSmallest(TreeNode<T> node) {
        while (node != null) {
            pathStack.push(node);
            node = node.getLeft();
        }
    }


    @Override
    public boolean hasNext() {
        return !pathStack.isEmpty();
    }

    @Override
    public TreeNode<T> next() {
        if (pathStack.isEmpty()) {
            throw new NoSuchElementException();
        }
        TreeNode<T> next = pathStack.pop();
        pushPathToNextSmallest(next.getRight());
        return next;
    }
}
