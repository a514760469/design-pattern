package com.gds.memento;

/**
 * @author zhanglifeng
 * @since 2020-03-13 16:36
 */
public class Star {

    private StarType type;

    private int ageYears;

    private int massTons;

    public Star(StarType type, int ageYears, int massTons) {
        this.type = type;
        this.ageYears = ageYears;
        this.massTons = massTons;
    }

    public void timePasses() {
        ageYears *= 2;
        massTons *= 8;
        switch (type) {
            case RED_GIANT:
                type = StarType.WHITE_DWARF;
                break;
            case SUN:
                type = StarType.RED_GIANT;
                break;
            case SUPERNOVA:
                type = StarType.DEAD;
                break;
            case WHITE_DWARF:
                type = StarType.SUPERNOVA;
                break;
            case DEAD:
                massTons = 0;
                ageYears *= 2;
                break;
            default:
                break;
        }
    }

    StarMemento getMemento() {
        StarMementoInternal memento = new StarMementoInternal();
        memento.setAgeYears(ageYears);
        memento.setMassTons(massTons);
        memento.setType(type);
        return memento;
    }

    void setMemento(StarMemento memento) {
        StarMementoInternal state = (StarMementoInternal) memento;
        this.type = state.getType();
        this.ageYears = state.getAgeYears();
        this.massTons = state.getMassTons();
    }

    public StarType getType() {
        return type;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getMassTons() {
        return massTons;
    }

    public void setType(StarType type) {
        this.type = type;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public void setMassTons(int massTons) {
        this.massTons = massTons;
    }

    @Override
    public String toString() {
        return String.format("%s, age: %d years, mass: %d tons", type.toString(), ageYears, massTons);
    }

    /** 星星备忘录 */
    public interface StarMemento { }

    private class StarMementoInternal implements StarMemento {

        private StarType type;

        private int ageYears;

        private int massTons;

        public void setType(StarType type) {
            this.type = type;
        }

        public void setAgeYears(int ageYears) {
            this.ageYears = ageYears;
        }

        public void setMassTons(int massTons) {
            this.massTons = massTons;
        }

        public StarType getType() {
            return type;
        }

        public int getAgeYears() {
            return ageYears;
        }

        public int getMassTons() {
            return massTons;
        }
    }
}
