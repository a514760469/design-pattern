package com.gds.cache;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-04-02 10:56
 */
public class DBManager {

    private static MongoClient mongoClient;
    private static MongoDatabase db;
    private static boolean useMongoDB;

    private static Map<String, UserAccount> virtualDB;

    private DBManager() {
    }

    public static void createVirtualDb() {
        useMongoDB = false;
        virtualDB = new HashMap<>();
    }

    public static void connect() {
        useMongoDB = true;
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("test");
    }

    public static UserAccount readFromDb(String userId) {
        if (!useMongoDB) {
            if (virtualDB.containsKey(userId)) {
                return virtualDB.get(userId);
            }
            return null;
        }

        if (db == null) {
            connect();
        }

        FindIterable<Document> iterable = db.getCollection(CachingConstants.USER_ACCOUNT).find(new Document(CachingConstants.USER_ID, userId));
        if (iterable == null) {
            return null;
        }

        Document first = iterable.first();

        return new UserAccount(userId, first.getString(CachingConstants.USER_NAME), first.getString(CachingConstants.ADD_INFO));
    }


    /**
     * Write user account to DB.
     */
    public static void writeToDb(UserAccount userAccount) {
        if (!useMongoDB) {
            virtualDB.put(userAccount.getUserId(), userAccount);
            return;
        }
        if (db == null) {
            connect();
        }
        db.getCollection(CachingConstants.USER_ACCOUNT).insertOne(
                new Document(CachingConstants.USER_ID, userAccount.getUserId())
                        .append(CachingConstants.USER_NAME, userAccount.getUserName())
                        .append(CachingConstants.ADD_INFO, userAccount.getAdditionalInfo())
        );
    }

    /**
     * Update DB.
     */
    public static void updateDb(UserAccount userAccount) {
        if (!useMongoDB) {
            virtualDB.put(userAccount.getUserId(), userAccount);
            return;
        }
        if (db == null) {
            connect();
        }
        db.getCollection(CachingConstants.USER_ACCOUNT).updateOne(
                new Document(CachingConstants.USER_ID, userAccount.getUserId()),
                new Document("$set", new Document(CachingConstants.USER_NAME, userAccount.getUserName())
                        .append(CachingConstants.ADD_INFO, userAccount.getAdditionalInfo())));
    }

    public static void upsertDb(UserAccount userAccount) {
        if (!useMongoDB) {
            virtualDB.put(userAccount.getUserId(), userAccount);
            return;
        }
        if (db == null) {
            connect();
        }
        db.getCollection(CachingConstants.USER_ACCOUNT).updateOne(
                new Document(CachingConstants.USER_ID, userAccount.getUserId()),
                new Document("$set",
                        new Document(CachingConstants.USER_ID, userAccount.getUserId())
                                .append(CachingConstants.USER_NAME, userAccount.getUserName())
                                .append(CachingConstants.ADD_INFO, userAccount.getAdditionalInfo())
                ),
                new UpdateOptions().upsert(true)
        );
    }
}
