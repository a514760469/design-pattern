package com.gds.cache;

/**
 * @author zhanglifeng
 * @since 2020-04-02 14:39
 */
@SuppressWarnings("Duplicates")
public class App {

    public static void main(String[] args) {
        AppManager.initDb(false);
        AppManager.initCacheCapacity(3);

        useReadThroughAndWriteBehindStrategy();

    }

    public static void useCacheAsideStrategy() {
        AppManager.initCachingPolicy(CachingPolicy.ASIDE);

        UserAccount u3 = new UserAccount("0003", "这是你", "你大度我");
        UserAccount u4 = new UserAccount("0004", "煮熟的", "按足底");
        UserAccount u5 = new UserAccount("0005", "Isaac", "He is allergic to mustard.");

        AppManager.save(u3);
        AppManager.save(u4);
        AppManager.save(u5);

        System.out.println(AppManager.printCacheContent());
        AppManager.find("0003");
        System.out.println(AppManager.printCacheContent());
        AppManager.find("0004");
        System.out.println(AppManager.printCacheContent());

        AppManager.find("0003");
    }

    public static void useReadThroughAndWriteBehindStrategy() {
        AppManager.initCachingPolicy(CachingPolicy.BEHIND);

        UserAccount u3 = new UserAccount("0003", "这是你", "你大度我");
        UserAccount u4 = new UserAccount("0004", "煮熟的", "按足底");
        UserAccount u5 = new UserAccount("0005", "Isaac", "He is allergic to mustard.");

        AppManager.save(u3);
        AppManager.save(u4);
        AppManager.save(u5);
        System.out.println(AppManager.printCacheContent());

        AppManager.find("0003");
        System.out.println(AppManager.printCacheContent());

        UserAccount u6 = new UserAccount("0006", "Yasha", "She is an only child.");
        AppManager.save(u6);

        System.out.println(AppManager.printCacheContent());
        AppManager.find("0004");
        System.out.println(AppManager.printCacheContent());
    }

    public static void useReadThroughAndWriteAroundStrategy() {
        AppManager.initCachingPolicy(CachingPolicy.AROUND);

        UserAccount u2 = new UserAccount("0002", "四五千", "擦擦擦");

        AppManager.save(u2);
        System.out.println(AppManager.printCacheContent());

        System.out.println(AppManager.find("0002"));// miss
        System.out.println(AppManager.printCacheContent());
        System.out.println(AppManager.find("0002"));// hit
        System.out.println(AppManager.printCacheContent());
        u2 = AppManager.find("0002");
        assert u2 != null;
        u2.setUserName("四大");
        AppManager.save(u2);
        System.out.println(AppManager.printCacheContent());
        AppManager.find("0002");
        System.out.println(AppManager.find("0002"));
    }

    public static void useReadAndWriteThroughStrategy() {
        AppManager.initCachingPolicy(CachingPolicy.THROUGH);

        UserAccount u1 = new UserAccount("0001", "西红柿", "屌丝");

        AppManager.save(u1);

        System.out.println(AppManager.printCacheContent());
        AppManager.find("0001");
        AppManager.find("0001");
        AppManager.find("0002");
    }

}
