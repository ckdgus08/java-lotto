package lotto.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputBuyMoneyAmount() {
        System.out.println("구매급액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
