package racingcar.controller.dto.response;

import java.util.Map;

public record CarsResponse(
        Map<String, Integer> response
) {
}
