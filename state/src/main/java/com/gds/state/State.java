package com.gds.state;

/**
 * @author zhanglifeng
 * @since 2020-03-16 15:43
 */
public interface State {

    void onEnterState();

    void observe();

}
