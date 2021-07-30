package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GameTest {

    Lotto previousLotto = new Lotto(Arrays.asList(
            new Ball(1),
            new Ball(2),
            new Ball(3),
            new Ball(4),
            new Ball(5),
            new Ball(6)));

    @Test
    @DisplayName("게임 횟수와, 지난 당첨번호를 입력받아 게임을 생성한다.")
    void create() {
        Game game = new Game(14, previousLotto);
    }
}
