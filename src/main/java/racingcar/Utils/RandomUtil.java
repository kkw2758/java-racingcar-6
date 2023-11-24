package racingcar.Utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;


    private static int pickRandomNumberInRange() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<Integer> pickRandomNumbersInRange(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(pickRandomNumberInRange());
        }
        return randomNumbers;
    }
}
