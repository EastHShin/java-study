package techcourse.fp.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        });

        Car lambdaActual = car.move(() -> true);
        // assertThat(actual).isEqualTo(new Car("pobi", 1));
        assertThat(lambdaActual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });
        Car lambdaActual = car.move(() -> false);
        // assertThat(actual).isEqualTo(new Car("pobi", 0));
        assertThat(lambdaActual).isEqualTo(new Car("pobi", 0));
    }
}