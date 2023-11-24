package racingcar.controller.dto.response;

import java.util.List;

public record TotalRacingGameResponse(
        List<CarsResponse> carsResponses,
        List<String> victoryCarNames
) {
}
