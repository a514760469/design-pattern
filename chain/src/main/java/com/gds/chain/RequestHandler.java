package com.gds.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhanglifeng
 * @since 2020-01-17 11:37
 */
public abstract class RequestHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);

    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handlerRequest(Request req) {
        if (next != null) {
            next.handlerRequest(req);
        }
    }

    protected void printHandling(Request req) {
        LOGGER.info("{} 处理请求 “{}”", this, req);
    }

    @Override
    public abstract String toString();

}
