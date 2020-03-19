package com.gds.statemachine;

/**
 * 状态0：正常状态
 *
 * @author zhanglifeng
 * @since 2020-03-18 10:59
 */
public class Normal extends InputState {

    /**
     * 状态0：正常状态
     *      状态0中如果遇到/，说明可能会遇到注释，则进入状态1
     *
     * @param charAt
     * @param processor
     */
    @Override
    public void handleInput(char charAt, CodeProcessor processor) {
        if (charAt == backslash) {
            processor.setCurrentState(new CommentSymbol());
        } else {
            processor.putChar(charAt);
        }
    }
}
