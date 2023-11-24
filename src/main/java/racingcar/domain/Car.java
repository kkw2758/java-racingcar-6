package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int STEP_SIZE = 1;

    private final CarName carName;
    private int position = INITIAL_POSITION;

    private Car(CarName carName) {
        this.carName = carName;
    }

    public static Car from(String carName) {
        return new Car(CarName.from(carName));
    }

    public void moveCar() {
        position += STEP_SIZE;
    }

    public int getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }
}
