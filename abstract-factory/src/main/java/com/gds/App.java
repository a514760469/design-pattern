package com.gds;

import com.gds.elf.ElfKingdomFactory;
import com.gds.orc.OrcKingdomFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhanglifeng
 * @since 2020-01-13 18:15
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private King king;

    private Castle castle;

    private Army army;

    private void setKing(King king) {
        this.king = king;
    }

    private void setCastle(Castle castle) {
        this.castle = castle;
    }

    private void setArmy(Army army) {
        this.army = army;
    }

    private King getKing() {
        return king;
    }

    private Castle getCastle() {
        return castle;
    }

    private Army getArmy() {
        return army;
    }

    public void createKingdom(final KingdomFactory factory) {
        setArmy(factory.createArmy());
        setCastle(factory.createCastle());
        setKing(factory.createKing());
    }

    public static void main(String[] args) {
        App app = new App();
        app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF));
        LOGGER.info(app.getArmy().getDescription());
        LOGGER.info(app.getKing().getDescription());
        LOGGER.info(app.getCastle().getDescription());
        app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC));
        LOGGER.info(app.getArmy().getDescription());
        LOGGER.info(app.getKing().getDescription());
        LOGGER.info(app.getCastle().getDescription());

    }

    /*
     * 现在，我们可以为我们不同的王国工厂设计一个工厂。在本例中，我们创建了FactoryMaker
     */
    public static class FactoryMaker {

        public enum KingdomType {
            ELF, ORC
        }

        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELF:
                    return new ElfKingdomFactory();
                case ORC:
                    return new OrcKingdomFactory();
                default:
                    throw new IllegalArgumentException("KingdomType not supported.");
            }
        }
    }
}
