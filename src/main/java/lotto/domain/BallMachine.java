package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallMachine {
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 45;

    private static final List<Integer> numberBallList = initBallList();

    private static List<Integer> initBallList() {
        List<Integer> initBallList = new ArrayList<>();
        for (int i = MIN_BALL_NUMBER; i <= MAX_BALL_NUMBER; i++) {
            initBallList.add(i);
        }
        Collections.shuffle(initBallList);
        return initBallList;
    }

    private static int getRandomNumber() {
        return numberBallList.get(0);
    }
}
