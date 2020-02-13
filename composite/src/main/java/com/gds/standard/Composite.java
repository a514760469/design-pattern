package com.gds.standard;

import java.util.ArrayList;

/**
 * @author zhanglifeng
 * @since 2020-02-13 16:33
 * 树枝构件
 */
public class Composite extends Component {
    // 构件容器
    private ArrayList<Component> componentArrayList = new ArrayList<>();

    public void add(Component component) {
        this.componentArrayList.add(component);
    }

    public void remove(Component component) {
        this.componentArrayList.remove(component);
    }

    public ArrayList<Component> getChildren() {
        return this.componentArrayList;
    }
}
