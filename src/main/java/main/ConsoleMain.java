package main;

import domain.NormalFrame;
import domain.Player;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        Player player = InputView.inputPlayer();
        ResultView.scoreBoard(player);

        List<NormalFrame> frames = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            frames.add(new NormalFrame(player));
        }

        for (int i = 0 ; i < 10 ; ) {
            NormalFrame frame = frames.get(i);

            if (frame.isEnd()) {
                i++;
                continue;
            }

            //Input - score
            int score = InputView.inputScore(i+1);
            frame.play(score);
        }
    }
}
