package bowling.domain.score;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoresTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void create(int maxPlayCount) {
        Scores scores = new Scores(maxPlayCount);
        assertThat(scores).isNotNull();
    }

    @DisplayName("maxPlayCount 오류")
    @Test
    void create_error() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Scores(1));
    }

    @DisplayName("normalFrame score normalRegister test")
    @Test
    void normalFrame_score() {
        Scores scores = new Scores(2);

        scores.normalRegister(0);
        scores.normalRegister(10);

        assertThat(scores.sumOfScore()).isEqualTo(10);
    }

    @DisplayName("finalFrame score normalRegister test")
    @Test
    void finalFrame_score() {
        Scores scores = new Scores(3);

        scores.normalRegister(10);
        scores.normalRegister(10);
        scores.normalRegister(10);

        assertThat(scores.sumOfScore()).isEqualTo(30);
    }

    @DisplayName("over maxPlayCount test")
    @ParameterizedTest
    @CsvSource({"1,1,1"})
    void normalFrame_score_exception(int first, int second, int third) {
        Scores scores = new Scores(2);

        scores.normalRegister(first);
        scores.normalRegister(second);

        Assertions.assertThrows(IllegalArgumentException.class, () -> scores.normalRegister(third));
    }

    @DisplayName("over maxScore")
    @ParameterizedTest
    @CsvSource({"1,10"})
    void over_max_score(int first, int second) {
        Scores scores = new Scores(2);

        scores.normalRegister(first);
        Assertions.assertThrows(IllegalArgumentException.class, () -> scores.normalRegister(second));
    }
}