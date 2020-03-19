package com.gds.workflow;

/**
 * @author zhanglifeng
 * @since 2020-03-16 18:41
 */
public class Client {

    public static void main(String[] args) {
        FlowContext context = new FlowContext();
        context.setMessage("请假一天。");
        context.start(context);
    }
}
