package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    static void divisibleByPrice(int total) {
        if (total % LottoConstants.LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 금액은 티캣 값으로 나눌 수 있어야 합니다.");
            throw new IllegalArgumentException("[ERROR] 금액은 티캣 값으로 나눌 수 있어야 합니다.");
        }
    }

    static int testParseInt(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력된 값이 정수가 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 입력된 값이 정수가 아닙니다.");
        }
    }

    static String reformat(String input) {
        return input.replaceAll("[\\s,]+", "");
    }

    static void testPositive(int total) {
        if (total <= 0) {
            System.out.println("[ERROR] 금액은 0 이상이어야 합니다.");
            throw new IllegalArgumentException("[ERROR] 금액은 0 이상이어야 합니다.");
        }
    }

    static String askTotal() {
        System.out.println("금액을 입력해 주세요.");
        return Console.readLine();
    }

    static int validateTotal(String total) {
        while (true) {
            try {
                int totalInt = testParseInt(reformat(total));
                divisibleByPrice(totalInt);
                testPositive(totalInt);
                return totalInt;
            } catch (IllegalArgumentException e) {
                total = askTotal();
            }
        }
    }

    static int getTotal() {
        String totalInput = askTotal();
        return validateTotal(totalInput);
    }


    public static void main(String[] args) {
        int total = getTotal();
        System.out.println(total);
    }
}
