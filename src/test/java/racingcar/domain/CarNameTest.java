package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @DisplayName("자동차의 이름이 1자이상 5자 이하면 정상 동작한다.")
    @ParameterizedTest
    //given
    @ValueSource(strings = {"차", "안녕하세요"})
    void carNameLengthNotExceptionTest(String carName) {
        // when & then
        assertDoesNotThrow(() -> CarName.from(carName));
    }

    @DisplayName("자동차의 이름이 1자이상 5자 이하가 아니면 예외 발생")
    @ParameterizedTest
    //given
    @ValueSource(strings = {"", "이름이긴자동차"})
    void carNameLengthExceptionTest(String carName) {
        // when & then
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임에 참여하는 자동차의 이름은 1자 이상 5자 이하만 가능합니다");
    }
}
