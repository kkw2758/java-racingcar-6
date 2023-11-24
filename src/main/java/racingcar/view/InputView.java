package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.view.console.ConsoleReader;
import racingcar.view.console.ConsoleWriter;

public class InputView {
    private final String NUMBER_REGULAR_EXPRESSION = "\\d+";
    private final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String TRY_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String COMMA_SEPARATOR = ",";

    public int requestTryCount() {
        ConsoleWriter.printlnMessage(TRY_COUNT_REQUEST_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public List<String> requestCarNames() {
        ConsoleWriter.printlnMessage(CAR_NAMES_REQUEST_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateCarNamesSeparators(userInput, COMMA_SEPARATOR);
        return parseStringToList(userInput, COMMA_SEPARATOR);
    }

    private void validateCarNamesSeparators(String message, String separator) {
        validateEdgeSeparators(message, separator);
        validateDuplicatedSeparators(message, separator);
    }

    private void validateEdgeSeparators(String message, String separator) {
        if (hasEdgeSeparators(message, separator)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasEdgeSeparators(String message, String separator) {
        return message.startsWith(separator) || message.endsWith(separator);
    }

    private void validateDuplicatedSeparators(String message, String separator) {
        if (hasDuplicatedSeparators(message, separator)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedSeparators(String message, String separator) {
        return message.contains(separator.repeat(2));
    }

    private List<String> parseStringToList(String message, String separator) {
        return Arrays.stream(split(message, separator)).toList();
    }

    private String[] split(String message, String separator) {
        return message.split(separator);
    }

    private void validateNumber(String userInput) {
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumber(String userInput) {
        return !userInput.matches(NUMBER_REGULAR_EXPRESSION);
    }
}
