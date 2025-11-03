package lotto;

public class Application {
    public static void main(String[] args) {
        Total total = Total.init();

        Ticket ticket = Ticket.init(total);
        Ticket.printAllTickets(ticket);

        Lotto lotto = Lotto.init();
        Bonus bonus = Bonus.init(lotto);
    }
}
