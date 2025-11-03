package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new Bonus(6, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_최소값_미만이면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new Bonus(-1, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_최댓값_초과면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new Bonus(46, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기능_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7, lotto);
        assertThat(bonus.get()).isEqualTo(7);
    }
}
