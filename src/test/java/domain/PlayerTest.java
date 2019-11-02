package domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"SS", "SSSS"})
    public void 플레이어_이름은_3글자가_아니면_안된다(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Player.of(name));
    }
}