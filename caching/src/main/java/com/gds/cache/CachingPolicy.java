package com.gds.cache;

/**
 * 缓存策略
 * @author zhanglifeng
 * @since 2020-04-02 11:19
 */
public enum CachingPolicy {

    /**
     * #read-through
     * 缓存被经过, 缓存与数据库保持一致
     *
     * #write-through cache
     * 首先将数据写入缓存，然后写入数据库。
     * 缓存与数据库保持一致，写操作总是通过缓存到达主数据库。
     * 引入了额外的写延迟, 与read-through结合使用时, 获得了数据一致性保证
     * 且不必使用缓存失效技术。
     *
     */
    THROUGH("through"),

    /**
     * #Write-around 数据直接写入数据库， 只有读取的数据才能进入缓存。
     * 可以与read-through结合使用
     */
    AROUND("around"),

    /**
     * write-back 或 write-behind
     * 应用程序将数据写入缓存，缓存会立即确认，并在延迟一段时间后将数据写入数据库。
     * 提高了写性能。
     * 主要缺点：如果缓存失效，数据可能会永久丢失。
     */
    BEHIND("behind"),

    /**
     * #cache-aside
     * 缓存位于一边, 适合读多的应用场景.
     * 由应用程序负责从数据库中获取数据并填充缓存，
     * read-through中此逻辑由库或独立缓存提供支持，
     * 可以与数据库中数据模型不同.
     * 如果必须保证数据的新鲜度，开发人员要么使缓存条目无效，要么使用适当的写策略
     */
    ASIDE("aside");

    private String policy;

    CachingPolicy(String policy) {
        this.policy = policy;
    }

    public String getPolicy() {
        return policy;
    }
}
