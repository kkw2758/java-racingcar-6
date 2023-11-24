package racingcar.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private static final int MIN_CARS_LENGTH = 2;
    private static final int INITIAL_CAR_POSITION = 0;
    private static final int START_RANGE = 0;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> cars) {
        validateCars(cars);
        return new Cars(cars.stream()
                .map(Car::from)
                .toList());
    }

    public void moveCars(List<Boolean> moveInfo) {
        IntStream.range(START_RANGE, cars.size())
                .filter(moveInfo::get)
                .forEach(i -> cars.get(i).moveCar());
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(INITIAL_CAR_POSITION);
    }

    public List<String> getCarNamesAtPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getCarName)
                .map(CarName::getValue)
                .toList();
    }

    private static void validateCars(List<String> cars) {
        validateCarsDuplicate(cars);
        validateLength(cars);
    }

    private static void validateLength(List<String> cars) {
        if (checkCarsSize(cars)) {
            throw new IllegalArgumentException("경주에 참여하는 자동차는 2대 이상만 가능합니다.");
        }
    }

    private static boolean checkCarsSize(List<String> cars) {
        return cars.size() < MIN_CARS_LENGTH;
    }

    private static void validateCarsDuplicate(List<String> cars) {
        if (checkCarsDuplicate(cars)) {
            throw new IllegalArgumentException("게임에 참여하는 자동차의 이름이 중복될 수 없습니다.");
        }
    }

    private static boolean checkCarsDuplicate(List<String> cars) {
        return cars.stream().distinct().count() != cars.size();
    }
}
