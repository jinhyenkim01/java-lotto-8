package lotto;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Total total = Total.init();

        Ticket ticket = Ticket.init(total);
        Ticket.print(ticket);

        Lotto lotto = Lotto.init();
        Bonus bonus = Bonus.init(lotto);

        Map<Winnings, Integer> result = Calculation.calculateAll(ticket.get(), lotto.get(), bonus.get());
        Calculation.printResult(result);
        Calculation.printEarnings(result, total);
    }
}
