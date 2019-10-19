package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoresTest {

    @Test
    public void 입력된_숫자만큼_점수기회를_갖는다(){
        // given
        int chance = 3;
        Scores scores = new Scores(chance);

        // when, then
        assertThat(scores.getChanceNumber()).isEqualTo(chance);
    }

    @Test
    public void 주어진_기회만큼_점수등록() {
        int chance = 2;
        Scores scores = new Scores(chance);

        scores.register(5);
        scores.register(3);

        assertThat(scores.getChanceNumber()).isEqualTo(chance);
    }

    @Test
    void 최대점수를_초과한경우_에러를_발생시킨다() {
        int chance = 2;
        Scores scores = new Scores(chance);

        scores.register(5);
        scores.register(3);
        Assertions.assertThrows(IllegalAccessException.class, () -> scores.register(1));
    }
}