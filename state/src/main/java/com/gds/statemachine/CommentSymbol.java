package com.gds.statemachine;

/**
 * 状态1
 * @author zhanglifeng
 * @since 2020-03-18 11:05
 */
public class CommentSymbol extends InputState {

    /**
     * 状态1中 如果遇到 / , 说明是单行注释，进入状态2
     *        如果遇到 * , 说明是多行注释，进入状态3
     *        如果没有遇到 / 或*，说明是路径符合或除号，进入状态0
     * @param charAt
     * @param processor
     */
    @Override
    public void handleInput(char charAt, CodeProcessor processor) {
        if (charAt == super.backslash) {
            processor.setCurrentState(new SingleLineComment());
        } else if (charAt == super.asterisk) {
            processor.setCurrentState(new MultiLineComment());
        } else {
            processor.putChar('/');// 进入状态1之前的 /。状态0时会过滤掉
            processor.putChar(charAt);
            processor.setCurrentState(new Normal());
        }
    }

}
