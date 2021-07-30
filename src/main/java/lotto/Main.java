package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {


    public static void main(String[] args) {

        int moneyCount = InputView.inputBuyMoneyAmount();

        Game game = new Game(moneyCount);
        ResultView.printLottoCount(game);
        ResultView.printLottoNumbers(game);

        Lotto lotto = InputView.inputPreviousLottoNumbers();
        game.setPreviousLotto(lotto);

        ResultView.printResult();

    }
}
