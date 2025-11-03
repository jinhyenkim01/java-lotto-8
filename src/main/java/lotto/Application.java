package lotto;

public class Application {
    public static void main(String[] args) {
        Total total = Total.init();
        Lotto lotto = Lotto.init();
        Bonus bonus = Bonus.init(lotto);

        System.out.println(total.get());
        System.out.println(lotto.get());
        System.out.println(bonus.get());
    }
}
