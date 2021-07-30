package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();
    private Lotto previousLotto;

    public Game(int totalMoney) {
        for (int i = 0; i < totalMoney / LOTTO_PRICE; i++) {
            lottos.add(new Lotto());
        }
    }

    public int getCountOfSameNumberLotto(int sameCount) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.getSameNumberCount(previousLotto) == sameCount)
                .count();
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void setPreviousLotto(Lotto previousLotto) {
        this.previousLotto = previousLotto;
    }
}
