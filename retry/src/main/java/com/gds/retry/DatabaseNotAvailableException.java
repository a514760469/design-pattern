package com.gds.retry;

/**
 * @author zhanglifeng
 * @since 2020-05-08 13:53
 */
public class DatabaseNotAvailableException extends BusinessException {

    private static final long serialVersionUID = -3750769625095997799L;

    /**
     * Ctor.
     *
     * @param message the error message
     */
    public DatabaseNotAvailableException(String message) {
        super(message);
    }
}
