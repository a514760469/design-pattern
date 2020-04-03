package com.gds.cache;

import java.util.Optional;

/**
 * @author zhanglifeng
 * @since 2020-04-02 14:43
 */
public class AppManager {

    private static CachingPolicy cachingPolicy;

    private AppManager() {
    }

    public static void initDb(boolean useMongoDb) {
        if (useMongoDb) {
            DBManager.connect();
        } else {
            DBManager.createVirtualDb();
        }
    }

    public static void initCachingPolicy(CachingPolicy policy) {
        AppManager.cachingPolicy = policy;
        if (AppManager.cachingPolicy == CachingPolicy.BEHIND) {
            // 注册一个新的虚拟机关闭挂钩。
            Runtime.getRuntime().addShutdownHook(new Thread(CacheStore::flushCache));
        }
        CacheStore.clearCache();
    }

    public static void initCacheCapacity(int capacity) {
        CacheStore.initCapacity(capacity);
    }

    public static UserAccount find(String userId) {
        if (cachingPolicy == CachingPolicy.THROUGH || cachingPolicy == CachingPolicy.AROUND) {
            return CacheStore.readThrough(userId);
        } else if (cachingPolicy == CachingPolicy.BEHIND) {
            return CacheStore.readThroughWithWriteBackPolicy(userId);
        } else if (cachingPolicy == CachingPolicy.ASIDE) {
            return findAside(userId);
        }
        return null;
    }

    public static void save(UserAccount userAccount) {
        if (cachingPolicy == CachingPolicy.THROUGH) {
            CacheStore.writeThrough(userAccount);
        } else if (cachingPolicy == CachingPolicy.AROUND) {
            CacheStore.writeAround(userAccount);
        } else if (cachingPolicy == CachingPolicy.BEHIND) {
            CacheStore.writeBehind(userAccount);
        } else if (cachingPolicy == CachingPolicy.ASIDE) {
            saveAside(userAccount);
        }
    }

    public static String printCacheContent() {
        return CacheStore.print();
    }

    private static void saveAside(UserAccount userAccount) {
        DBManager.updateDb(userAccount);
        CacheStore.invalidate(userAccount.getUserId());
    }

    private static UserAccount findAside(String userId) {
        Optional<UserAccount> opt = Optional.ofNullable(CacheStore.get(userId));
        if (!opt.isPresent()) {
            UserAccount userAccount = Optional.ofNullable(DBManager.readFromDb(userId)).orElse(null);
            if (userAccount != null) {
                CacheStore.set(userId, userAccount);
            }
            return userAccount;
        }
        return null;
    }
}
