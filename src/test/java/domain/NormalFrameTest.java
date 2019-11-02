package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NormalFrameTest {
    private NormalFrame normalFrame;
    private Player player;

    @BeforeEach
    void setUp() {
        player = Player.of("123");
        normalFrame = new NormalFrame(player);
    }

    @Test
    void 객체생성() {
        //then
        assertThat(normalFrame).isNotNull();
        assertThat(normalFrame.getPlayer()).isNotNull();
        assertThat(normalFrame.getScores()).isNotNull();
    }

    @Test
    void play() {
        //when
        normalFrame.play(5);
        normalFrame.play(3);

        //then
        assertThat(normalFrame.getTotalScore()).isEqualTo(8);
    }

    @Test
    void frame종료여부_확인() {
        //when
        normalFrame.play(5);
        normalFrame.play(3);

        assertTrue(normalFrame.isEnd());
    }

    @Test
    void 프레임에서_2와_8이_입력됐을때_스페어가된다() {
        List<NormalFrame> normalFrames = new ArrayList<>();
        normalFrame.play(2);
        normalFrame.play(8);
        normalFrames.add(normalFrame);

        ResultView.getScoreString(normalFrames);
        System.out.println(normalFrame.getScores());
    }
}