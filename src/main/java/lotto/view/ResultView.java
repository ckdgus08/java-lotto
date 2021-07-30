package lotto.view;

import lotto.domain.Game;
import lotto.domain.Lotto;

public class ResultView {

    public static void printLottoCount(Game game) {
        System.out.println(game.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Game game) {
        for (Lotto lotto : game.getLottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}
