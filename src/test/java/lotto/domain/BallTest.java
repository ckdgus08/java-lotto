package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    @DisplayName("로또 볼 생성")
    void create() {
        Ball ball1 = new Ball(1);
        Ball ball2 = new Ball(45);
        assertThat(ball1).isEqualTo(new Ball(1));
        assertThat(ball2).isEqualTo(new Ball(45));
    }

    @Test
    @DisplayName("1~45 이외의 숫자가 포함되면 에러가 발생한다.")
    void validLottoNumbers() {
        assertThatThrownBy(() -> new Ball(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Ball(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
