package com.gds.statemachine;

/**
 * 状态4 多行注释可能要结束
 * @author zhanglifeng
 * @since 2020-03-19 15:18
 */
public class MultiLineCommentEnding extends InputState {

    /**
     * 状态4中如果遇到 / ，说明多行注释结束，则恢复状态0
     * 状态4中不是遇到/ ，说明多行注释只是遇到 * ，还要继续，则恢复状态3
     *
     * @param charAt
     * @param processor
     */
    @Override
    public void handleInput(char charAt, CodeProcessor processor) {
        if (charAt == super.backslash) {
            processor.setCurrentState(new Normal());
        } else {
            processor.setCurrentState(new MultiLineComment());
        }
    }

}
