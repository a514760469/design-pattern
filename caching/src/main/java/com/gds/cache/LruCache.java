package com.gds.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LRU数据结构由一个哈希表和一个双链表组成。
 * @author zhanglifeng
 * @since 2020-04-01 11:24
 */
public class LruCache<T> {

    int capacity;
    Map<String, Node> cache = new HashMap<>();

    Node head;// 头
    Node end;// 尾

    /**
     * 初始化 capacity 大小的 lru 缓存
     * @param capacity 容量
     */
    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 从缓存中取数据
     */
    public T get(String id) {
        if (cache.containsKey(id)) {
            Node node = cache.get(id);
            remove(node);
            setHead(node);
            return node.t;
        }
        return null;
    }

    /**
     * 从链表中删除节点node
     * @param node 节点
     */
    public void remove(Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            end = node.previous;
        }
    }

    /**
     * 将节点 node 移到列表的前面。
     * @param node 节点
     */
    public void setHead(Node node) {
        // 移动到最前端
        node.next = head;
        node.previous = null;

        if (head != null) {
            head.previous = node;
        }

        head = node;
        if (end == null) {
            end = head;
        }
    }

    /**
     * 放入一个值
     * @param id
     * @param t
     */
    public void set(String id, T t) {
        if (cache.containsKey(id)) {
            // 刷新缓存
            Node old = cache.get(id);
            old.t = t;
            remove(old);
            setHead(old);
        } else {
            // 存入缓存
            Node newNode = new Node(id, t);
            if (cache.size() >= capacity) {
                // 缓存满了删除尾结点元素
                System.out.println("Cache is Full! removing " + end.id + " from cache. ");
                cache.remove(end.id);// 删除Lru数据 hash表和链表
                remove(end);
            }
            setHead(newNode);
            cache.put(id, newNode);
        }
    }

    public boolean contains(String id) {
        return cache.containsKey(id);
    }

    public void invalidate(String id) {
        Node rmNode = cache.remove(id);
        if (rmNode != null) {
            System.out.println("缓存失效");
            remove(rmNode);
        }
    }

    public boolean isFull() {
        return cache.size() >= capacity;
    }

    public T getLruData() {
        return end.t;
    }

    public void clear() {
        head = null;
        end = null;
        cache.clear();
    }

    /**
     * 以列表形式返回缓存数据
     */
    public List<T> getCacheDataInListForm() {
        List<T> result = new ArrayList<>();
        Node tmp = head;
        while (tmp != null) {
            result.add(tmp.t);
            tmp = tmp.next;
        }
        return result;
    }

    /**
     * 重新设置缓存大小，如果小于原大小，会清空缓存
     * @param newCapacity newCapacity
     */
    public void setCapacity(int newCapacity) {
        if (capacity > newCapacity) {
            clear();
        } else {
            this.capacity = newCapacity;
        }
    }

    /**
     * 双向链表
     */
    class Node {
        String id;
        T t;
        Node previous;
        Node next;

        public Node(String id, T t) {
            this.id = id;
            this.t = t;
        }
    }



}
