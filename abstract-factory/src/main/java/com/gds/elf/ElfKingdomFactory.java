package com.gds.elf;

import com.gds.Army;
import com.gds.Castle;
import com.gds.King;
import com.gds.KingdomFactory;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:26
 */
public class ElfKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
