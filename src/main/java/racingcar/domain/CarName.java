package racingcar.domain;

public class CarName {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String value;

    private CarName(String carName) {
        this.value = carName;
    }

    public String getValue() {
        return value;
    }

    public static CarName from(String carName) {
        validateCarName(carName);
        return new CarName(carName);
    }

    private static void validateCarName(String carName) {
        validateCarNameLength(carName);
    }

    private static void validateCarNameLength(String carName) {
        if (checkCarNameLength(carName)) {
            throw new IllegalArgumentException("게임에 참여하는 자동차의 이름은 1자 이상 5자 이하만 가능합니다");
        }
    }

    private static boolean checkCarNameLength(String carName) {
        return carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH;
    }
}
