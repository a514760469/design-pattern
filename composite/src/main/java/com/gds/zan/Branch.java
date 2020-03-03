package com.gds.zan;

import java.util.ArrayList;

/**
 * @author zhanglifeng
 * @since 2020-01-21 16:39
 */
public class Branch extends Corp implements IBranch {

    // 下属
    private ArrayList<Corp> corps = new ArrayList<>();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    @Override
    public void add(Corp corp) {
        corp.setParent(this);// 设置父节点
        corps.add(corp);
    }

    @Override
    public ArrayList<Corp> getSubordinateInfo() {
        return corps;
    }

}
