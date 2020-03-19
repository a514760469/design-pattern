package com.gds.statemachine;

/**
 * 状态3 多行注释
 * @author zhanglifeng
 * @since 2020-03-19 14:52
 */
public class MultiLineComment extends InputState {


    /**
     * 状态3中如果遇到 * ，说明多行注释 可能 要结束，则进入状态4
     * 状态3中不是遇到 * ，说明多行注释还在继续，则维持状态3
     * @param charAt
     * @param processor
     */
    @Override
    public void handleInput(char charAt, CodeProcessor processor) {
        if (charAt == super.asterisk) {
            processor.setCurrentState(new MultiLineCommentEnding());
        }
        // 维持状态3
    }
}
