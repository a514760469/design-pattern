package com.gds.zan;

import java.util.ArrayList;

/**
 * @author zhanglifeng
 * @since 2020-01-21 16:36
 */
public interface IBranch {

    void add(Corp corp);

    ArrayList<Corp> getSubordinateInfo();

}
