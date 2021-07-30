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
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또의 번호는 1~45 사이이어야 한다.")
    void validLottoNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
