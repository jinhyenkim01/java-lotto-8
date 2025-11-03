package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    static Lotto init() {
        while (true) {
            try {
                String lottoInput = Lotto.ask();
                List<Integer> lottoList = Lotto.parse(lottoInput);
                System.out.println();
                return new Lotto(lottoList);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static List<Integer> validate(List<Integer> numbers) {
        size(numbers);
        amount(numbers);
        duplicate(numbers);
        return numbers;
    }

    static List<Integer> parse(String lottery) {
        try {
            return Arrays.stream(lottery.split(","))
                    .map(String::trim)
                    .filter(s -> !s.trim().isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 0~9 사이의 숫자와 쉼표 이외의 문자는 사용 불가능합니다.");
        }
    }

    static void size(List<Integer> lottery) {
        if (lottery.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    static void amount(List<Integer> lottery) {
        for (int lotteryNo : lottery) {
            if (lotteryNo < Constants.MIN_NUMBER || lotteryNo > Constants.MAX_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(
                                "[ERROR] 로또 번호는 %d과 %d 사이여야 합니다.", Constants.MIN_NUMBER, Constants.MAX_NUMBER));
            }
        }
    }

    static void duplicate(List<Integer> lottery) {
        if (lottery.stream().distinct().count() != lottery.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복될 수 없습니다.");
        }
    }

    static String ask() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> get() {
        return numbers;
    }
}
