package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.constant.Error;
import racingcar.util.Utils;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        validateCars(carNames);
        carList = generateCarList(carNames);
    }

    public LinkedHashMap<String, Integer> getCarNamePositionMap() {
        LinkedHashMap<String, Integer> carNamePositionMap = new LinkedHashMap<>();
        for (Car car : carList) {
            carNamePositionMap.put(car.getName(), car.getPosition());
        }
        return carNamePositionMap;
    }

    public List<String> getVictoryCarNames() {
        List<String> victoryCarNames = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : carList) {
            if (maxPosition == car.getPosition()) {
                victoryCarNames.add(car.getName());
            }
        }
        return victoryCarNames;
    }

    // 테스트를 위해 public접근 제한자로 설정 해놓았습니다.
    public int getMaxPosition() {
        List<Integer> carPositionList = new ArrayList<>();
        for (Car car : carList) {
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

    public int size() {
        return carList.size();
    }

    public void moveCar(int index) {
        Car car = carList.get(index);
        car.addPosition();
    }

    private List<Car> generateCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String car : carNames) {
            carList.add(new Car(car));
        }
        return carList;
    }

    private void validateCars(String[] carNames) {
        if (Utils.hasDuplicateMember(carNames)) {
            throw new IllegalArgumentException(Error.DUPLICATE_CAR_NAME_ERROR.getMessage());
        }
    }
}
