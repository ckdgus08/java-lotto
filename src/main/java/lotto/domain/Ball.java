package lotto.domain;

import java.util.*;

public class Ball implements Comparable<Ball> {

    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 45;
    private static final List<Integer> numberBallList = initBallList();

    private final int number;

    public Ball() {
        this(getRandomNumber());
        Collections.shuffle(numberBallList);
    }

    public Ball(int number) {
        validNumberRange(number);
        this.number = number;
    }

    private static int getRandomNumber() {
        return numberBallList.get(0);
    }

    private static List<Integer> initBallList() {
        List<Integer> initBallList = new ArrayList<>();
        for (int i = MIN_BALL_NUMBER; i <= MAX_BALL_NUMBER; i++) {
            initBallList.add(i);
        }
        Collections.shuffle(initBallList);
        return initBallList;
    }

    private void validNumberRange(int number) {
        if (!(number >= MIN_BALL_NUMBER && number <= MAX_BALL_NUMBER)) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_BALL_NUMBER + " ~ " + MAX_BALL_NUMBER + "사이만 허용됩니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Ball o) {
        return number - o.number;
    }
}
