package com.gds.chain;

/**
 * @author zhanglifeng
 * @since 2020-01-17 11:40
 * 兽人指挥官
 */
public class OrcCommander extends RequestHandler {

    public OrcCommander(RequestHandler handler) {
        // 设置下一个处理器
        super(handler);
    }

    @Override
    public void handlerRequest(Request req) {
        if (req.getRequestType().equals(RequestType.DEFEND_CASTLE)) {
            printHandling(req);
            req.markHandler();
        } else {
            super.handlerRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc commander 兽人指挥官";
    }
}
