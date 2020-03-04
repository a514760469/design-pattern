package com.gds.standard;

/**
 * @author zhanglifeng
 * @since 2020-03-03 18:49
 */
public class ConcreteCommandB extends Command {

    // 对哪个receiver进行处理
    private Receiver receiver;

    public ConcreteCommandB(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doSomething();
    }
}
