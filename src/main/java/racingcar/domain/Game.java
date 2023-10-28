package racingcar.domain;

public class Game {

    private final Cars cars;
    private final int tryCount;

    public Game(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount.getTryCount();
    }

    public void racingGame() {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            cars.printCarPosition();
        }
        Output.printVictoryCarNames(cars.getVictoryCarNames());
    }

    private void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            if (Utils.getRandomNumber() >= 4) {
                cars.moveCar(i);
            }
        }
    }
}
