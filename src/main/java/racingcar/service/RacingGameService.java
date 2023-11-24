package racingcar.service;

import static racingcar.Utils.RandomUtil.pickRandomNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.dto.response.CarsResponse;
import racingcar.controller.dto.response.TotalRacingGameResponse;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class RacingGameService {
    private static final int MIN_NUMBER_TO_MOVE = 4;

    public TotalRacingGameResponse racingGame(Cars cars, TryCount tryCount) {
        List<CarsResponse> carsResponses = new ArrayList<>();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            carsResponses.add(doRound(cars));
        }
        return new TotalRacingGameResponse(carsResponses, getVictoryCarNames(cars));
    }

    private CarsResponse doRound(Cars cars) {
        List<Boolean> moveInfo = createMoveInfo(cars.getSize());
        cars.moveCars(moveInfo);
        return cars.toResponse();
    }

    private List<Boolean> createMoveInfo(int carsLength) {
        return pickRandomNumbersInRange(carsLength).stream()
                .map(number -> number >= MIN_NUMBER_TO_MOVE)
                .toList();
    }

    private List<String> getVictoryCarNames(Cars cars) {
        return cars.getCarNamesAtPosition(cars.getMaxPosition());
    }
}
