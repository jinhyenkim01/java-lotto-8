package lotto;

public class Application {
    public static void main(String[] args) {
        Total total = Total.init();
        Lotto lotto = Lotto.init();

        System.out.println(total.getTotal());
        System.out.println(lotto.getNumbers());
    }
}
