package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또를 생성한다.")
    void create() {
        Lotto result = new Lotto(Arrays.asList(
                new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5),
                new Ball(6)));
        assertThat(result.hasBallsCount(6)).isTrue();
    }

    @Test
    @DisplayName("자동으로 로또를 생성한다.")
    void createRandom() {
        Lotto result = new Lotto();
        assertThat(result.hasBallsCount(6)).isTrue();
    }

    @Test
    @DisplayName("로또 넘버가 6개가 아니거나, 중복되면 에러가 발생한다.")
    void validLottoNumberCount() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5),
                new Ball(6),
                new Ball(7))))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5))))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5),
                new Ball(5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
