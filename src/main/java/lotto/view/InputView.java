package lotto.view;

import lotto.domain.Ball;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner;

    public static int inputBuyMoneyAmount() {
        scanner = new Scanner(System.in);
        System.out.println("구매급액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Lotto inputPreviousLottoNumbers() {
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Ball> previousBalls = Arrays.stream(scanner.nextLine().split(","))
                .map(value -> new Ball(Integer.parseInt(value.trim())))
                .collect(Collectors.toList());
        System.out.println();
        return new Lotto(previousBalls);
    }
}
