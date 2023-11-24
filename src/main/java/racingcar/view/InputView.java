package racingcar.view;

import racingcar.view.console.ConsoleReader;
import racingcar.view.console.ConsoleWriter;

public class InputView {
    private final String NUMBER_REGULAR_EXPRESSION = "\\d+";
    private final String TRY_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String COMMA_SEPARATOR = ",";

    public int requestTryCount() {
        ConsoleWriter.printlnMessage(TRY_COUNT_REQUEST_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Integer.parseInt(userInput);
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
