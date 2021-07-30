package lotto.view;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Reward;

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

    public static void printResult(Game game) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + Reward.getMoneyFromSameCount(i) + "원)-" + game.getCountOfSameNumberLotto(i) + "개");
        }
    }
}
