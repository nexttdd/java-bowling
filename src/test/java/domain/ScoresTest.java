package domain;

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
}