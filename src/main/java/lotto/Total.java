package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Total {

    public static void divisible(int total) {
        if (total % LottoConstants.LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 금액은 티캣 값으로 나눌 수 있어야 합니다.");
            throw new IllegalArgumentException("[ERROR] 금액은 티캣 값으로 나눌 수 있어야 합니다.");
        }
    }
    public static int parse(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 0~9사이의 숫자와 쉼표 이외의 문자는 사용 불가능합니다.");
            throw new IllegalArgumentException("[ERROR] 0~9사이의 숫자와 쉼표 이외의 문자는 사용 불가능합니다.");
        }
    }
    public static String reformat(String input) {
        return input.replaceAll("[\\s,]+", "");
    }
    public static void positive(int total) {
        if (total <= 0) {
            System.out.println("[ERROR] 금액은 0 이상이어야 합니다.");
            throw new IllegalArgumentException("[ERROR] 금액은 0 이상이어야 합니다.");
        }
    }
    public static String ask() {
        System.out.println("금액을 입력해 주세요.");
        return Console.readLine();
    }
    public static int validate(String total) {
        while (true) {
            try {
                int totalInt = parse(reformat(total));
                positive(totalInt);
                divisible(totalInt);
                return totalInt;
            } catch (IllegalArgumentException e) {
                total = ask();
            }
        }
    }
    public static int get() {
        String totalInput = ask();
        return validate(totalInput);
    }
}
