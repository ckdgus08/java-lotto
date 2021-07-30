package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GameTest {

    @Test
    @DisplayName("게임 횟수와, 지난 당첨번호를 입력받아 게임을 생성한다.")
    void create() {
        Game game = new Game(14, Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
