package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TotalTest {
    @Test
    void 구입금액이_1000으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Total(900)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_0_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Total(-1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기능_테스트() {
        Total total = new Total(1000);
        assertThat(total.get()).isEqualTo(1000);
    }
}
