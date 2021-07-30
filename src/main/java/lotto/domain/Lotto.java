package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static int BALL_COUNT = 6;

    public Set<Ball> balls = new HashSet<>();

    public Lotto() {
        while (!hasBallsCount(BALL_COUNT)) {
            balls.add(new Ball());
        }
    }

    public Lotto(List<Ball> balls) {
        this.balls = balls.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        validNumberCount();
    }

    public boolean hasBallsCount(int size) {
        return balls.size() == size;
    }

    private void validNumberCount() {
        if (!hasBallsCount(BALL_COUNT)) {
            throw new IllegalArgumentException("로또는 중복되지 않는 " + BALL_COUNT + "개의 숫자를 가져야합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(balls, lotto.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
