package com.gds.statemachine;

/**
 * 状态2 单行注释
 * @author zhanglifeng
 * @since 2020-03-18 13:47
 */
public class SingleLineComment extends InputState {

    /**
     * 状态2中遇到回车符\n，说明单行注释结束，则恢复状态0
     * @param charAt
     * @param processor
     */
    @Override
    public void handleInput(char charAt, CodeProcessor processor) {

        if (charAt == super.lineBreaks) {
            processor.putChar(charAt);
            processor.setCurrentState(new Normal());
        }
        // else do nothing
    }
}
