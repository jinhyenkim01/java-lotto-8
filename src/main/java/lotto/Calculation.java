package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.EnumMap;
import java.text.DecimalFormat;

public class Calculation {
    static int matches(List<Integer> ticket, List<Integer> winner) {
        int count = 0;
        Set<Integer> winnerSet = new HashSet<>(winner);
        for (int number : ticket) {
            if (winnerSet.contains(number)) {
                count = count + 1;
            }
        }
        return count;
    }

    static boolean bonus(List<Integer> ticket, int bonus) {
        return ticket.contains(bonus);
    }

    static Winnings calculate(List<Integer> ticket, List<Integer> winner, int bonus) {
        int match = matches(ticket, winner);
        boolean bonusMatch = bonus(ticket, bonus);
        return Winnings.determine(match, bonusMatch);
    }

    static Map<Winnings, Integer> calculateAll(List<List<Integer>> tickets, List<Integer> winner, int bonus) {
        Map<Winnings, Integer> count = new EnumMap<>(Winnings.class);
        for (Winnings winning : Winnings.values()) {
            count.put(winning, 0);
        }
        for (List<Integer> ticket : tickets) {
            Winnings winning = calculate(ticket, winner, bonus);
            count.put(winning, count.get(winning) + 1);
        }
        return count;
    }

    static void printResult(Map<Winnings, Integer> result) {
        System.out.println("당첨 통계");
        System.out.printf("3개 일치 (%,d원) - %,d개%n", Winnings.FIFTH.getWinnings(), result.get(Winnings.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %,d개%n", Winnings.FOURTH.getWinnings(), result.get(Winnings.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %,d개%n", Winnings.THIRD.getWinnings(), result.get(Winnings.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %,d개%n",
                Winnings.SECOND.getWinnings(), result.get(Winnings.SECOND));
        System.out.printf("6개 일치 (%,d원) - %,d개%n", Winnings.FIRST.getWinnings(), result.get(Winnings.FIRST));
    }

    static void printEarnings(Map<Winnings, Integer> result, Total total) {
        int totalWinnings = 0;
        for (Winnings winning : Winnings.values()) {
            totalWinnings = totalWinnings + (result.get(winning) * winning.getWinnings());
        }
        double earningsRate = (double) totalWinnings / (double) total.get();
        DecimalFormat df = new DecimalFormat("0.0%");
        String percent = df.format(earningsRate);
        System.out.print("총 수익률은 ");
        System.out.print(percent);
        System.out.print("입니다.");
    }
}