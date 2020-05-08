package com.gds.retry;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * @author zhanglifeng
 * @since 2020-05-08 16:11
 */
public class RetryExponentialBackoff<T> implements BusinessOperation<T> {

    private static final Random RANDOM = new Random();

    private final BusinessOperation<T> op;
    private final int maxAttempts;
    private final long delay;
    private final AtomicInteger attempts;
    private final Predicate<Exception> test;
    private final List<Exception> errors;

    @SafeVarargs
    public RetryExponentialBackoff(BusinessOperation<T> op, int maxAttempts, long delay, Predicate<Exception>... ignoreTests) {
        this.op = op;
        this.maxAttempts = maxAttempts;
        this.delay = delay;
        this.attempts = new AtomicInteger();
        this.errors = new ArrayList<>();
        this.test = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
    }

    /**
     * @return 重试时遇到的错误，按顺序
     */
    public List<Exception> errors() {
        return Collections.unmodifiableList(errors);
    }

    /**
     * 重试次数
     */
    public int attempts() {
        return this.attempts.intValue();
    }

    @Override
    public T perform() throws BusinessException {
        do {
            try {
                return this.op.perform();
            } catch (BusinessException e) {
                this.errors.add(e);

                // 大于重试次数 或者Predicate<Exception> 返回true
                if (this.attempts.incrementAndGet() >= this.maxAttempts || !test.test(e)) {
                    throw e;
                }
                try {
                    long testDelay = (long) (Math.pow(2, this.attempts()) * 1000 + RANDOM.nextInt(1000));
                    long delay = Math.min(testDelay, maxAttempts);
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    // ignore
                }
            }

        } while (true);
    }
}
