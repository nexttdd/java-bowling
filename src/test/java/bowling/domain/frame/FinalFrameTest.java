package bowling.domain.frame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinalFrameTest {
    @Test
    void spare() {
        FinalFrame frame = FinalFrame.of("ASV");
        frame.play(3);
        frame.play(7);
        frame.play(7);

        assertThat(frame.isEnd()).isTrue();
    }

    @Test
    void strike() {
        FinalFrame frame = FinalFrame.of("ASV");
        frame.play(10);
        frame.play(7);

        assertThat(frame.isEnd()).isTrue();
    }

    @Test
    void normal() {
        FinalFrame frame = FinalFrame.of("ASV");
        frame.play(0);
        frame.play(7);

        assertThat(frame.isEnd()).isTrue();
    }
}