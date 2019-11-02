package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.BowlingConst;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoresTest {
    private Scores scores;

    @BeforeEach
    void setUp() {
        scores = new Scores(BowlingConst.NORMAL_CHANE);
    }

    @Test
    public void 주어진_기회만큼_점수등록() {
        scores.register(5);
        scores.register(3);

        assertThat(scores.getChanceNumber()).isEqualTo(BowlingConst.NORMAL_CHANE);
    }

    @Test
    void 최대점수를_초과한경우_에러를_발생시킨다() {
        scores.register(5);
        scores.register(3);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> scores.register(1));
    }

    @Test
    void 최대점수가_10을_초과하면_에러() {
        scores.register(5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> scores.register(6));
    }

    @ParameterizedTest
    @CsvSource({"2,8,true", "10,0,false", "3,3,false"})
    void 스페어여부_확인(int first, int second, boolean expect) {
        scores.register(first);

        if (second != 0) {
            scores.register(second);
        }

        assertThat(scores.isSpare()).isEqualTo(expect);
    }
}