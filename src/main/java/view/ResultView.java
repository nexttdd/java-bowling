package view;

import domain.NormalFrame;
import domain.Player;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static StringBuilder sb = new StringBuilder("");

    public static void scoreBoard(Player player) {
        scoreBoard(player, new ArrayList<>());
    }

    public static void scoreBoard(Player player, List<NormalFrame> normalFrames) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        System.out.println(player.toString() + " | " + getScoreString(normalFrames));
    }

    public static String getScoreString(List<NormalFrame> normalFrames) {
        if (normalFrames.isEmpty()) {
            return "     " + String.join("", Collections.nCopies(9, StringUtils.rightPad("|", 7)));
        }

        return normalFrames.stream()
                .map(normalFrame -> String.valueOf(normalFrame.getScores()))
                .collect(Collectors.joining("|"));
    }
}
