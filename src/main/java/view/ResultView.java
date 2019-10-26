package view;

import domain.Player;
import domain.Scores;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

public class ResultView {
    public static void scoreBoard(Player player) {
        scoreBoard(player, null);
    }

    public static void scoreBoard(Player player, Scores scores) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        //System.out.println(player.toString() + String.join("", Collections.nCopies(11, StringUtils.rightPad("|", 5) )));
        System.out.println(player.toString() + " | " + scores);
    }
}
