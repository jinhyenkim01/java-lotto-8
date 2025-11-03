package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus, Lotto lotto) {
        this.bonus = validate(bonus, lotto);
    }

    static Bonus init(Lotto lotto) {
        while (true) {
            try {
                String bonusInput = Bonus.ask();
                int bonusInt = Total.parse(Total.reformat(bonusInput));
                System.out.println();
                return new Bonus(bonusInt, lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static int validate(int bonus, Lotto lotto) {
        check(bonus);
        unique(bonus, lotto);
        return bonus;
    }

    static void check(int bonus) {
        if (bonus < Constants.MIN_NUMBER || bonus > Constants.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] 보너스 번호는 %d과 %d 사이여야 합니다.", Constants.MIN_NUMBER, Constants.MAX_NUMBER));
        }
    }

    static void unique(int bonus, Lotto lotto) {
        List<Integer> lottoList = lotto.get();
        if (lottoList.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    static String ask() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int get() {
        return bonus;
    }
}
