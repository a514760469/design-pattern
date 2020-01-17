package com.gds.orc;

import com.gds.Army;
import com.gds.Castle;
import com.gds.King;
import com.gds.KingdomFactory;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:26
 */
public class OrcKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }
}
