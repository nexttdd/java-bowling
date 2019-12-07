package bowling.domain.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class NormalFrameTest {

    private NormalFrame normalFrame;

    @BeforeEach
    void setUp() {
        normalFrame = NormalFrame.of("player1");
    }


    @DisplayName("일반 프레임 생성")
    @Test
    void create() {
        assertThat(normalFrame).isNotNull();
        assertThat(normalFrame.getScores()).isNotNull();
        assertThat(normalFrame.getPlayerName()).isEqualTo("player1");
    }

    @DisplayName("일반 프레임 - play, 종료 확인")
    @ParameterizedTest
    @CsvSource({"10, true", "9, false"})
    void play(int score, boolean result) {
        normalFrame.play(score);

        assertThat(normalFrame.isEnd()).isEqualTo(result);
    }
}