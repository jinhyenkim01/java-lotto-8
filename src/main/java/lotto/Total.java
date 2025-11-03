package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Total {
    private final int total;

    public Total(int total) {
        this.total = validate(total);
    }

    static Total init() {
        while (true) {
            try {
                String totalInput = Total.ask();
                int totalInt = parse(reformat(totalInput));
                System.out.println();
                return new Total(totalInt);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validate(int totalInt) {
        positive(totalInt);
        divisible(totalInt);
        return totalInt;
    }

    public static String reformat(String input) {
        return input.replaceAll("[\\s,]+", "");
    }

    public static int parse(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 0~9 사이의 숫자와 쉼표 이외의 문자는 사용 불가능합니다.");
        }
    }

    public static void divisible(int total) {
        if (total % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 티켓 값으로 나눌 수 있어야 합니다.");
        }
    }

    public static void positive(int total) {
        if (total <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0 이상이어야 합니다.");
        }
    }

    public static String ask() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public int get() {
        return total;
    }
}
