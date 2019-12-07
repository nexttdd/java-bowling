package bowling;

import bowling.domain.BowlingGame;
import bowling.view.InputView;

public class ConsoleMain {
    public static void main(String[] args) {
        String player = InputView.player();
        BowlingGame game = new BowlingGame(player);
        game.play();
    }
}
