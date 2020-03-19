package com.gds.workflow;

/**
 * @author zhanglifeng
 * @since 2020-03-16 18:10
 */
public class FlowContext {

    /*流程是否结束*/
    private boolean isOver;

    /**
     * 流程状态
     * 0：通过 1:驳回 2.退回整改 3.已申请
     */
    private FlowState state;

    private String message;// 消息

    private Node node;

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public FlowState getState() {
        return state;
    }

    public void setState(FlowState state) {
        this.state = state;
    }

    public boolean start(FlowContext context) {
        context.setNode(new LeadNode());// 初始节点
        context.setState(FlowState.APPLIED);// 状态为申请中
        // 发起请求
        context.getNode().nodeHandler(context);
        if ("HR李".equals(node.getName()) && FlowState.PASS.equals(context.getState()) && context.isOver()) {
            System.out.println("审核通过，流程结束");
            return true;
        } else {
            System.out.println("审核未通过，流程已经结束");
            return false;
        }

    }

    public enum FlowState {
        // 0：通过 1:驳回 2.退回整改 3.已申请
        PASS(0), REJECT(1), RETURN(2), APPLIED(3);

        private int code;

        public int getCode() {
            return code;
        }

        FlowState(int code) {
            this.code = code;
        }
    }
}
