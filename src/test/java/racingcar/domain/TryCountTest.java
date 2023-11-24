package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {
    @DisplayName("시도할 횟수가 1이상이 아니라면 예외 발생")
    @Test
    void tryCountExceptionTest() {
        // given
        int tryCount = 0;
        // when & then
        assertThatThrownBy(() -> TryCount.from(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1이상만 가능합니다.");

    }

    @DisplayName("시도할 횟수가 1이상이 라면 정상 동작한다.")
    @Test
    void tryCountNotExceptionTest() {
        // given
        int tryCount = 1;
        // when & then
        assertDoesNotThrow(() -> TryCount.from(tryCount));
    }
}
