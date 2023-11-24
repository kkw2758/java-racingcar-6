package racingcar.controller;

import racingcar.controller.dto.response.TotalRacingGameResponse;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public GameManager(InputView inputView,
                       OutputView outputView,
                       RacingGameService racingGameService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        Cars cars = Cars.from(inputView.requestCarNames());
        TryCount tryCount = TryCount.from(inputView.requestTryCount());
        TotalRacingGameResponse totalRacingGameResponse = racingGameService.racingGame(cars, tryCount);
        outputView.printTotalRacingGameResult(totalRacingGameResponse);
    }
}
