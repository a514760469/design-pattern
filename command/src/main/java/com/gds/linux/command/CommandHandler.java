package com.gds.linux.command;

/**
 * 责任链模式的handler
 * @author zhanglifeng
 * @since 2020-03-23 13:52
 */
public abstract class CommandHandler {

    private CommandHandler nextOperator;

    public final String handleMassage(CommandVO vo) {
        String result = "";
        // 判断是否是自己处理
        if (vo.getParamList().size() == 0 || vo.getParamList().contains(this.getOperateParam())) {
            result = this.echo(vo);
        } else {
            if (this.nextOperator != null) {
                result = this.nextOperator.handleMassage(vo);
            } else {
                result = "命令无法执行";
            }
        }
        return result;
    }

    // 设置剩余参数由谁处理
    public void setNext(CommandHandler nextOperator) {
        this.nextOperator = nextOperator;
    }

    /**
     * 每个处理器都要处理一个后缀参数
     * @return
     */
    protected abstract String getOperateParam();

    /**
     * 每个处理者都必须实现处理任务
     * @param commandVO
     * @return
     */
    protected abstract String echo(CommandVO commandVO);

}
