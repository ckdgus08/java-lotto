package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .filter(this::validNumberRange)
                .collect(Collectors.toSet());
    }

    private boolean validNumberRange(int number) {
        return number > 0 && number < 46;
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
