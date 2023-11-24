package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.controller.dto.response.CarsResponse;
import racingcar.controller.dto.response.TotalRacingGameResponse;
import racingcar.view.console.ConsoleWriter;

public class OutputView {
    private static String VICTORY_CAR_NAMES_TAG = "최종 우승자 : %s";
    private static String VICTORY_CAR_NAMES_DELIMITER = " : ";
    private static String COMMA_DELIMITER = ",";
    private static String CAR_POSITION_CHAR = "-";
    private static String EMPTY_STRING = "";
    private static String RESULT_TAG = "실행 결과";

    public void printTotalRacingGameResult(TotalRacingGameResponse totalRacingGameResponse) {
        printCarsResponses(totalRacingGameResponse.carsResponses());
        printVictoryCarNames(totalRacingGameResponse.victoryCarNames());
    }

    private void printCarsResponses(List<CarsResponse> carsResponses) {
        ConsoleWriter.printlnMessage(EMPTY_STRING);
        ConsoleWriter.printlnMessage(RESULT_TAG);
        carsResponses.forEach(this::printCarsResponse);
    }

    private void printVictoryCarNames(List<String> victoryCarNames) {
        ConsoleWriter.printlnFormat(VICTORY_CAR_NAMES_TAG, String.join(COMMA_DELIMITER, victoryCarNames));
    }

    private void printCarsResponse(CarsResponse carsResponse) {
        Map<String, Integer> response = carsResponse.response();
        response.keySet().forEach(
                key -> ConsoleWriter.printlnMessage(
                        key + VICTORY_CAR_NAMES_DELIMITER + CAR_POSITION_CHAR.repeat(response.get(key))));
        ConsoleWriter.printlnMessage("");
    }
}
