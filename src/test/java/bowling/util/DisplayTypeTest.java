package bowling.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayTypeTest {
    @Test
    void getCurrentFrameScore() {
        String displayChar = DisplayType.getChar(0, 0);
        assertThat(displayChar).isEqualTo("-");

        displayChar = DisplayType.getChar(10, 10);
        assertThat(displayChar).isEqualTo("X");

        displayChar = DisplayType.getChar(1, 1, 0);
        assertThat(displayChar).isEqualTo("1|-");

        displayChar = DisplayType.getChar(10, 0, 10);
        assertThat(displayChar).isEqualTo("-|/");

        displayChar = DisplayType.getChar(10, 3, 7);
        assertThat(displayChar).isEqualTo("3|/");
    }
}