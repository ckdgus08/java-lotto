package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    @DisplayName("공 생성")
    void create() {
        Ball result = Ball.from(3);
        assertThat(result).isEqualTo(Ball.from(3));
    }

    @Test
    @DisplayName("1~45 이외의 숫자가 올때 에러가 발생한다.")
    void validBallNumberRange() {
        assertThatThrownBy(() -> Ball.from(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Ball.from(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
