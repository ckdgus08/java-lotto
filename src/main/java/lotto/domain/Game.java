package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Lotto> lottos = new ArrayList<>();
    private Lotto previousLotto;

    public Game(int count, Lotto previousLotto) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        this.previousLotto = previousLotto;
    }
}
