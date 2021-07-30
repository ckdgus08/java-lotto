package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 45;
    private static int NUMBER_COUNT = 6;
    private static List<Integer> numberBallList = initBallList();

    public Set<Integer> numbers;

    public Lotto() {
        this(numberBallList.subList(0, NUMBER_COUNT));
        Collections.shuffle(numberBallList);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .filter(this::validNumberRange)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        validNumberCount();
    }

    private static List<Integer> initBallList() {
        List<Integer> initBallList = new ArrayList<>();
        for (int i = MIN_BALL_NUMBER; i <= MAX_BALL_NUMBER; i++) {
            initBallList.add(i);
        }
        Collections.shuffle(initBallList);
        return initBallList;
    }

    private boolean validNumberRange(int number) {
        return number >= MIN_BALL_NUMBER && number <= MAX_BALL_NUMBER;
    }

    private void validNumberCount() {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또는 중복되지 않는 " + NUMBER_COUNT + "개의 숫자를 가져야합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
