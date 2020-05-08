package com.gds.retry;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanglifeng
 * @since 2020-05-08 15:22
 */
@Slf4j
public class App {

    public static void main(String[] args) throws BusinessException {
//        noErrors();
//        noRetry();
        errorWithRetry();
//        errorWithRetryExponentialBackoff();
    }


    private static void noErrors() throws BusinessException {
        BusinessOperation<String> op = new FindCustomer("123");
        String perform = op.perform();
        log.info("操作结果：{}", perform);
    }

    private static void noRetry() throws BusinessException {
        BusinessOperation<String> op = new FindCustomer("123", new CustomerNotFoundException("用户未找到。"));
        try {
            op.perform();
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行一次op将自动触发最多5次重试尝试，每次尝试之间有100毫秒的延迟，忽略在尝试时抛出的CustomerNotFoundException。
     * 如果抛出DatabaseNotFoundException，那么操作会立即失败，不管剩下多少次尝试。
     */
    private static void errorWithRetry() throws BusinessException {

        final Retry<String> op = new Retry<>(
                new FindCustomer("123",
//                        new CustomerNotFoundException("用户未找到。"),
//                        new CustomerNotFoundException("仍然未找到"),
                        new CustomerNotFoundException("再找不到放弃吧")
                ),
                5,
                1000,
                e -> CustomerNotFoundException.class.isAssignableFrom(e.getClass())
        );
        String customerId = op.perform();
        log.info("执行过程中出现错误：{}", op.errors());
        log.info("customerId: {}, attempts: {}", customerId, op.attempts());
    }

    private static void errorWithRetryExponentialBackoff() throws BusinessException {
        final RetryExponentialBackoff<String> op = new RetryExponentialBackoff<>(
                new FindCustomer("123", new CustomerNotFoundException("用户未找到。")),
                6,
                30000,
                e -> CustomerNotFoundException.class.isAssignableFrom(e.getClass())
        );
        String customerId = op.perform();
        log.info("customerId: {}, attempts: {}", customerId, op.attempts());
    }
}
