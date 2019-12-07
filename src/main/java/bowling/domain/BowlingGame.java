package bowling.domain;

import bowling.domain.frame.FinalFrame;
import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.view.InputView;
import bowling.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Frame> frames;
    private String player;

    public BowlingGame(String player) {
        this.frames = new ArrayList<>();
        this.player = player;
        intiFrames();
    }

    private void intiFrames() {
        for (int i = 0; i < 9; i++) {
            frames.add(NormalFrame.of(player));
        }

        frames.add(FinalFrame.of(player));
    }

    public void play() {
        OutputView.scoreBoard(frames, player);
        int currentFrame = 0;
        while(currentFrame < 10) {
            frames.get(currentFrame).play(InputView.score(currentFrame + 1));
            OutputView.scoreBoard(frames, player);

            if (frames.get(currentFrame).isEnd()) {
                currentFrame++;
            }
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public String getPlayer() {
        return player;
    }
}
