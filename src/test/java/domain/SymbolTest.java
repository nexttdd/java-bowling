package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolTest {
    @Test
    void 일반점수_표현() {
        int score = 1;
        String symbol = Symbol.of(score);

        assertThat(symbol).isEqualTo(Integer.toString(score));
    }

    @Test
    void strike() {
        int score = 10;
        String symbol = Symbol.of(score);

        assertThat(symbol).isEqualTo("X");
    }
}
