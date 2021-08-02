package lotto.domain;

import java.util.List;

public class Game {
    private final List<Lotto> lottoList;
    private Lotto previousLotto;

    public Game(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void setPreviousLotto(Lotto previousLotto) {
        this.previousLotto = previousLotto;
    }

    public int getNumberOfRightLotto(int rightNumber) {
        return (int) lottoList.stream().
                filter(lotto -> lotto.getCountOfRightNumber(previousLotto) == rightNumber)
                .count();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoSize() {
        return lottoList.size();
    }
}
