package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차의 초기 위치는 0이다.")
    @Test
    void initialCarPositionTest() {
        // given
        Car car = Car.from("테스트");

        // when
        int actual = car.getPosition();
        int expected = 0;

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("자동차는 한번 움직일 때 1만큼 전진한다.")
    @Test
    void moveCarTest() {
        // given
        Car car = Car.from("테스트");

        // when
        car.moveCar();
        int actual = car.getPosition();
        int expected = 1;

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
