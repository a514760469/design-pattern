package com.gds.cache;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhanglifeng
 * @since 2020-04-02 10:42
 */
public class CacheStore {

    private static LruCache<UserAccount> cache;

    private CacheStore() {
    }

    public static void initCapacity(int capacity) {
        if (cache == null) {
            cache = new LruCache<>(capacity);
        } else {
            cache.setCapacity(capacity);
        }
    }

    public static UserAccount readThrough(String userId) {
        if (cache.contains(userId)) {
            // 缓存命中直接取缓存
            System.out.println("# 缓存命中");
            return cache.get(userId);
        }
        System.out.println("# 缓存miss");
        // 缓存未命中数据库中取，放入缓存
        UserAccount userAccount = DBManager.readFromDb(userId);
        cache.set(userId, userAccount);
        return userAccount;
    }

    public static void writeThrough(UserAccount userAccount) {
        // 缓存中有更新数据库
        if (cache.contains(userAccount.getUserId())) {
            DBManager.updateDb(userAccount);
        } else {
            DBManager.writeToDb(userAccount);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    public static void writeAround(UserAccount userAccount) {
        if (cache.contains(userAccount.getUserId())) {
            DBManager.updateDb(userAccount);
            cache.invalidate(userAccount.getUserId());// 缓存将会被刷新，删除旧数据
        } else {
            DBManager.writeToDb(userAccount);
        }
    }

    /**
     * readThrough + WriteBack 策略
     *
     * @param userId
     * @return
     */
    public static UserAccount readThroughWithWriteBackPolicy(String userId) {
        // read through
        if (cache.contains(userId)) {
            System.out.println("# cache hit!");
            return cache.get(userId);
        }
        System.out.println("# cache miss!");
        UserAccount userAccount = DBManager.readFromDb(userId);

        if (cache.isFull()) {
            System.out.println("# cache isFull! Lru数据入库");
            UserAccount lruData = cache.getLruData();
            DBManager.upsertDb(lruData);
        }

        if (userAccount != null) {
            cache.set(userId, userAccount);
        }

        return userAccount;
    }

    public static void writeBehind(UserAccount userAccount) {
        if (cache.isFull() && !cache.contains(userAccount.getUserId())) {
            System.out.println("# cache isFull! Lru数据入库");
            UserAccount lruData = cache.getLruData();
            DBManager.upsertDb(lruData);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    public static void clearCache() {
        if (cache != null) {
            cache.clear();
        }
    }


    public static void flushCache() {
        System.out.println("# 刷新缓存");
        Optional.ofNullable(cache)
                .map(LruCache::getCacheDataInListForm)
                .orElse(Collections.emptyList())
                .forEach(DBManager::updateDb);
    }

    public static String print() {
        return Optional.ofNullable(cache)
                .map(LruCache::getCacheDataInListForm)
                .orElse(Collections.emptyList())
                .stream()
                .map(userAccount -> userAccount.toString() + "\n")
                .collect(Collectors.joining("", "\n--CACHE CONTENT--\n", "----\n"));
    }

    public static UserAccount get(String userId) {
        return cache.get(userId);
    }

    public static void set(String userId, UserAccount userAccount) {
        cache.set(userId, userAccount);
    }

    public static void invalidate(String userId) {
        cache.invalidate(userId);
    }
}
