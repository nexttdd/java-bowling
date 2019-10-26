package view;

import domain.Player;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static Player inputPlayer() {
        System.out.print("플레이어 이름은(3 english letters)?: ");
        return Player.of(sc.nextLine());
    }

    public static int inputScore(int frame) {
        System.out.print(frame + "프레임 투구 : ");
        return Integer.parseInt(sc.nextLine());
    }
}
