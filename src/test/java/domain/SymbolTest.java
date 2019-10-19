package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolTest {
    @ParameterizedTest
    @CsvSource({"0, -", "1, 1", "9,9", "10,X"})
    void 일반점수_표현들(int number, String result) {
        String specialCharacter = Symbol.of(number);
        assertThat(specialCharacter).isEqualTo(result);
    }
}
