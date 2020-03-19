package com.gds.workflow;

/**
 * 领导节点
 * @author zhanglifeng
 * @since 2020-03-16 18:08
 */
public class LeadNode extends Node {

    @Override
    public void nodeHandler(FlowContext context) {
        System.out.println("领导节点。。。。。");
        /*
         * 根据当前流程的状态，来控制流程的走向
         * 判断流程是否结束
         */
        if (!context.isOver()) {
            System.out.println("读取申请的内容: " + context.getMessage()); //先读取申请的内容

            // 只有已申请状态才可以由领导审核
            if (FlowContext.FlowState.APPLIED.equals(context.getState())) {
                this.setName("张经理");
                context.setMessage(context.getMessage() + "。" + getName() + "，审核通过。\n");
                context.setState(FlowContext.FlowState.PASS);// 审核通过 并指向下一个节点
                context.setNode(new HrNode());
                context.getNode().nodeHandler(context);
            }

        } else {
            System.out.println("流程已经结束");
        }
    }

}
