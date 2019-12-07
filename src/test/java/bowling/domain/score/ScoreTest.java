package bowling.domain.score;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    @DisplayName("정상적인 점수 등록")
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 10})
    void register(int playScore) {
        Score score = new Score(playScore);

        assertThat(score.getScore()).isEqualTo(playScore);
    }

    @DisplayName("점수가 잘못된 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void register_exception(int playScore) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Score(playScore));
    }
}