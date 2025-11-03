package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    public List<Integer> get() {
        return numbers;
    }

    static List<Integer> parse(String lottery) {
        try {
            return Arrays.stream(lottery.split(","))
                    .filter(s -> !s.trim().isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 0~9사이의 숫자와 쉼표 이외의 문자는 사용 불가능합니다.");
        }
    }

    static void size(List<Integer> lottery) {
        if (lottery.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    static void amount(List<Integer> lottery) {
        for (int lotteryNo : lottery) {
            if (lotteryNo < 1 || lotteryNo > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이여야 합니다.");
            }
        }
    }

    static String ask() {
        System.out.println("로또 번호를 입력해 주세요.");
        return Console.readLine();
    }

    static List<Integer> validate(List<Integer> numbers) {
        size(numbers);
        amount(numbers);
        return numbers;
    }

    static Lotto init() {
        while (true) {
            try {
                String lottoInput = Lotto.ask();
                List<Integer> lottoList = Lotto.parse(lottoInput);
                return new Lotto(lottoList);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
