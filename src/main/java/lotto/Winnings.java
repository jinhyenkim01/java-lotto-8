package lotto;

public enum Winnings {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int match;
    private final boolean bonus;
    private final int winnings;

    Winnings(int match, boolean bonus, int winnings) {
        this.match = match;
        this.bonus = bonus;
        this.winnings = winnings;
    }

    public int getMatch() {
        return match;
    }

    public boolean getBonus() {
        return bonus;
    }

    public int getWinnings() {
        return winnings;
    }

    public static Winnings determine(int match, boolean bonus) {
        for (Winnings winnings : values()) {
            if ((winnings.match == match) && (winnings.match != 5)) {
                return winnings;
            }
            if ((winnings.match == match) && (winnings.bonus == bonus)) {
                return winnings;
            }
        }
        return NONE;
    }
}