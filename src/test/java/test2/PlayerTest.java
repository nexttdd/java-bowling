package test2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class PlayerTest {
    @Test
    public void 사용자_이름이_3글자인_경우() {
        Player player = new Player("AAA");
        assertEquals(player.toString().length(), 3);
    }

    @Test
    void 사용자_이름이_3글자_넘는경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player("AAAA"));
    }

    @Test
    void 사용자_이름이_null인경우() {
        Assertions.assertThrows(NullPointerException.class, () -> new Player(null));
    }
}