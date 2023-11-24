package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameManager;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager(
                new InputView(),
                new OutputView(),
                new RacingGameService()
        );
        gameManager.run();
        Console.close();
    }
}
