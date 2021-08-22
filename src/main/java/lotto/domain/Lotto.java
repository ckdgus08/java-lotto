package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final Set<Ball> balls;

    private Lotto(Set<Ball> balls) {
        validNumberCountSize(balls);
        this.balls = balls;
    }

    public static Lotto from(Set<Ball> balls) {
        return new Lotto(balls);
    }

    public static Lotto from(int... numbers) {
        Set<Ball> balls = Arrays.stream(numbers)
                .mapToObj(Ball::from)
                .collect(Collectors.toSet());
        return new Lotto(balls);
    }

    public int getSameNumberCount(Lotto previousLotto) {
        return (int) balls.stream()
                .filter(previousLotto.balls::contains)
                .count();
    }

    public boolean containBonusBall(Ball ball) {
        return balls.contains(ball);
    }

    private void validNumberCountSize(Set<Ball> balls) {
        if (balls.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수는 " + NUMBER_SIZE + "개가 되어야합니다. (중복된 숫자도 오면 안됩니다.)");
        }
    }

    @Override
    public String toString() {
        return balls.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new)).toString();
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
