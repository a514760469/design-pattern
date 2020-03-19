package com.gds.workflow;

/**
 * Hr 节点
 * @author zhanglifeng
 * @since 2020-03-16 18:09
 */
public class HrNode extends Node {


    @Override
    public void nodeHandler(FlowContext context) {
        System.out.println("Hr节点。。。。。");
        if (!context.isOver()) {
            if (FlowContext.FlowState.PASS.equals(context.getState())) {
                setName("HR李");
                // 读取上一级的审核内容并加上自己的意见
                System.out.println(context.getMessage() + getName() + "审核通过 \n");
                // 审核通过
                context.setState(FlowContext.FlowState.PASS); //HR审核通过并指向下一个节点 ,如果没有下一个节点就把状态设置为终结
                context.setOver(true);
            }

        } else {
            System.out.println("流程已经结束");
        }


    }
}
