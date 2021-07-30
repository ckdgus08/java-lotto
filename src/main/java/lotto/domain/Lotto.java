package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static int BALL_COUNT = 6;

    public Set<Ball> balls;

    public Lotto() {
    }

    public Lotto(List<Integer> numbers) {
        this.balls = numbers.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        validNumberCount();
    }

    private void validNumberCount() {
        if (balls.size() != BALL_COUNT) {
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
