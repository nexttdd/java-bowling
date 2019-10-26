package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NormalFrameTest {

    private NormalFrame normalFrame;
    private String player = "player";

    @BeforeEach
    void setUp() {
        normalFrame = new NormalFrame(player);
    }

    @Test
    void 객체생성() {
        //then
        assertThat(normalFrame).isNotNull();
        assertThat(normalFrame.getPlayerName()).isEqualTo(player);
        assertThat(normalFrame.getScores()).isNotNull();
    }

    @Test
    void play() {
        //when
        normalFrame.play(5);
        normalFrame.play(3);

        //then
        assertThat(normalFrame.getTotalScore()).isEqualTo(8);
    }

    @ParameterizedTest
    void frame종료여부_확인() {
        //when
        normalFrame.play(5);
        normalFrame.play(3);
    }
}