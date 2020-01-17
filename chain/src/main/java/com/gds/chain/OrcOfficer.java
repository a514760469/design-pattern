package com.gds.chain;

/**
 * @author zhanglifeng
 * @since 2020-01-17 11:43
 * 兽人军官
 */
public class OrcOfficer extends RequestHandler {

    public OrcOfficer(RequestHandler next) {
        super(next);
    }

    @Override
    public void handlerRequest(Request req) {
        if (req.getRequestType().equals(RequestType.TORTURE_PRISONER)) {
            printHandling(req);
            req.markHandler();
        } else {
            super.handlerRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc Officer 兽人军官";
    }
}
