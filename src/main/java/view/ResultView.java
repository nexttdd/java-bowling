package view;

import domain.Player;
import domain.Scores;

public class ResultView {
    private static StringBuilder sb = new StringBuilder("");

    public static void scoreBoard(Player player) {
        scoreBoard(player, null);
    }

    public static void scoreBoard(Player player, Scores scores) {
        if (scores != null) {
            sb.append(scores);
            if (scores.isEnd()) {
                sb.append(" | ");
            }
        }

        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        //System.out.println(player.toString() + String.join("", Collections.nCopies(11, StringUtils.rightPad("|", 5) )));
        System.out.println(player.toString() + " | " + sb.toString());
    }
}
