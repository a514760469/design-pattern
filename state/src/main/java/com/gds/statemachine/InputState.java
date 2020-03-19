package com.gds.statemachine;

/**
 * @author zhanglifeng
 * @since 2020-03-18 10:55
 */
public abstract class InputState {

    protected char backslash = '/';
    protected char asterisk = '*';
    protected char lineBreaks = '\n';

    public abstract void handleInput(char charAt, CodeProcessor processor);

}
