package main;

import domain.Player;
import view.InputView;
import view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        Player player = InputView.inputPlayer();
        ResultView.scoreBoard(player);
    }
}
