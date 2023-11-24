package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void beforeEach() {
        this.cars = Cars.from(List.of("벤츠", "아우디", "페라리"));
    }

    @DisplayName("게임에 참여하는 자동차의 이름이 중복되면 에러발생")
    @Test
    void duplicateCarNamesExceptionTest() {
        // given
        List<String> carNames = List.of("벤츠", "벤츠", "페라리");

        // when & then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임에 참여하는 자동차의 이름이 중복될 수 없습니다.");

    }

    @DisplayName("게임에 참여하는 자동차가 2대 미만이면 에러발생")
    @Test
    void carsLengthExceptionTest() {
        // given
        List<String> emptyCarNames = List.of("벤츠");
        List<String> carNames = List.of("벤츠");

        // when & then
        assertAll(
                () -> assertThatThrownBy(() -> Cars.from(emptyCarNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("경주에 참여하는 자동차는 2대 이상만 가능합니다."),
                () -> assertThatThrownBy(() -> Cars.from(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("경주에 참여하는 자동차는 2대 이상만 가능합니다.")
        );
    }

    @DisplayName("가장 멀리 있는 자동차의 위치확인 테스트")
    @Test
    void getMaxPositionTest() {
        //given
        cars.moveCars(List.of(true, false, false));
        cars.moveCars(List.of(true, false, false));
        int expected = 2;

        // when
        int actual = cars.getMaxPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("특정 위치에 있는 자동차의 이름을 확인 테스트")
    @Test
    void getCarNamesAtPositionTest() {
        //given
        cars.moveCars(List.of(true, false, true));
        List<String> expected = List.of("벤츠", "페라리");

        // when
        List<String> actual = cars.getCarNamesAtPosition(1);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
