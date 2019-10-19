package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoresTest {
    @Test
    public void 주어진_기회만큼_점수등록() {
        int maxChance = 2;
        Scores scores = new Scores(maxChance);

        scores.register(5);
        scores.register(3);

        assertThat(scores.getChanceNumber()).isEqualTo(maxChance);
    }

    @Test
    void 최대점수를_초과한경우_에러를_발생시킨다() {
        int maxChance = 2;
        Scores scores = new Scores(maxChance);

        scores.register(5);
        scores.register(3);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> scores.register(1));
    }

    @Test
    void 최대점수가_10을_초과하면_에러() {
        int maxChance = 2;
        Scores scores = new Scores(maxChance);

        scores.register(5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> scores.register(6));
    }
}