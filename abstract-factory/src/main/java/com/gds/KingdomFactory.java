package com.gds;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:25
 */
public interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}
