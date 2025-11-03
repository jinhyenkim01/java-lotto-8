package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket {
    private final List<List<Integer>> ticket;

    public Ticket(Total total) {
        this.ticket = generateAll(amount(total.get()));
    }

    static Ticket init(Total total) {
        return new Ticket(total);
    }

    static List<Integer> generateOne() {
        List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> copy = new ArrayList<>(ticket);
        Collections.sort(copy);
        return copy;
    }

    static List<List<Integer>> generateAll(int number) {
        List<List<Integer>> allTickets = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> ticket = generateOne();
            allTickets.add(ticket);
        }
        return allTickets;
    }

    static void print(Ticket tickets) {
        System.out.printf("%d개를 구매했습니다.%n", tickets.get().size());
        for (List<Integer> ticket : tickets.get()) {
            System.out.println(ticket);
        }
        System.out.println();
    }

    static int amount(int total) {
        return total / Constants.LOTTO_PRICE;
    }

    public List<List<Integer>> get() {
        return ticket;
    }
}
