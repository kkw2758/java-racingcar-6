package racingcar.domain;

public class TryCount {
    private static final int MIN_TRY_COUNT = 1;
    private final int tryCount;

    private TryCount(int tryCount) {

        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public static TryCount from(int tryCount) {
        validateTryCount(tryCount);
        return new TryCount(tryCount);
    }

    private static void validateTryCount(int tryCount) {
        if (checkTryCountRange(tryCount)) {
            throw new IllegalArgumentException("시도할 횟수는 1이상만 가능합니다.");
        }
    }

    private static boolean checkTryCountRange(int tryCount) {
        return tryCount >= MIN_TRY_COUNT;
    }
}
