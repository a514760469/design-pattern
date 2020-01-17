package com.gds.chain;

/**
 * @author zhanglifeng
 * @since 2020-01-17 11:48
 */
public class OrcKing {

    RequestHandler chain;

    public OrcKing() {
        buildChain();
    }

    private void buildChain() {
        chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public void makeRequest(Request req) {
        chain.handlerRequest(req);
    }

}
