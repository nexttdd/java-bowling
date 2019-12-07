package bowling.view;

import bowling.domain.frame.Frame;
import bowling.util.DisplayUtil;

import java.util.List;

public class OutputView {
    public static void scoreBoard(List<Frame> frames, String player) {
        printTitle();
        printScores(frames, player);
    }

    private static void printTitle() {
        System.out.println("| NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |");
    }

    private static void printScores(List<Frame> frames, String player) {
        System.out.println(DisplayUtil.playerResult(frames, player));
    }
}
