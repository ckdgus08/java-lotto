import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final int DEFAULT_VALUE = 0;
    public static final int MINIMUM_INPUT_NUMBER = 0;
    public static final String DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "숫자가 아니거나 음수인 값은 올 수 없습니다.";

    public int splitAndSum(String input) {
        return add(splitAndReturnNumberList(input));
    }

    private int add(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> splitAndReturnNumberList(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.singletonList(DEFAULT_VALUE);
        }
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return stringArrayToNumberList(matcher.group(2).split(customDelimiter));
        }

        return stringArrayToNumberList(input.split(DELIMITER));
    }

    private List<Integer> stringArrayToNumberList(String[] input) {
        return Arrays.stream(input)
                .filter(this::valid)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean valid(String input) {
        if (Integer.parseInt(input) < MINIMUM_INPUT_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
        return true;
    }

}
