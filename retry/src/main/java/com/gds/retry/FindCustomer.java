package com.gds.retry;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 查找数据库
 * @author zhanglifeng
 * @since 2020-05-08 11:23
 */
public final class FindCustomer implements BusinessOperation<String> {

    private final String customerId;
    private final Deque<BusinessException> errors;

    /**
     * @param customerId 操作的结果
     * @param es 返回customerId之前可能抛出的异常
     */
    public FindCustomer(String customerId, BusinessException... es) {
        this.customerId = customerId;
        this.errors = new ArrayDeque<>(Arrays.asList(es));
    }

    @Override
    public String perform() throws BusinessException {
        if (!this.errors.isEmpty()) {
            throw this.errors.pop();
        }
        return customerId;
    }
}
