package com.gds.chain;

/**
 * @author zhanglifeng
 * @since 2020-01-17 11:45
 * 兽人士兵
 */
public class OrcSoldier extends RequestHandler {

    public OrcSoldier(RequestHandler next) {
        super(next);
    }

    @Override
    public void handlerRequest(Request req) {
        if (req.getRequestType().equals(RequestType.COLLECT_TAX)) {
            printHandling(req);
            req.markHandler();
        } else {
            super.handlerRequest(req);
        }
    }
    @Override
    public String toString() {
        return "Orc Soldier 兽人士兵";
    }
}
