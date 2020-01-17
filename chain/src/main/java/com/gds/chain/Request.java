package com.gds.chain;

import java.util.Objects;

/**
 * @author zhanglifeng
 * @since 2020-01-17 11:31
 */
public class Request {

    private final RequestType requestType;
    private final String requestDescription;
    private boolean handled;

    public Request(final RequestType requestType, final String requestDescription) {
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(requestDescription);
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void markHandler() {
        this.handled = true;
    }

    public boolean isHandled() {
        return handled;
    }

    @Override
    public String toString() {
        return requestDescription;
    }
}
