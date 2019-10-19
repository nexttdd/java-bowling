package view;

import domain.Player;

public class ResultView {
    public static void scoreBoard(Player player) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        System.out.println(player.toString() + " | | | | | | | | | |"   );
    }
}
