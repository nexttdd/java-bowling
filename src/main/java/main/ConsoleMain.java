package main;

import domain.NormalFrame;
import domain.Player;
import domain.Scores;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
//        Player player = InputView.inputPlayer();
        Player player= Player.of("ASD");
        ResultView.scoreBoard(player);

        List<NormalFrame> frames = new ArrayList<>();
        for (int i = 0 ; i < 10 ; ) {
            NormalFrame frame = new NormalFrame(player);
            frames.add(frame);

            //Input - score
            int score = InputView.inputScore(i+1);
            Scores scores = frame.play(score);
            ResultView.scoreBoard(player,frames);

            if (frame.isEnd()) {
                i++;
            }
        }
    }
}
