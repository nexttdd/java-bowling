package bowling.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String player() {
        System.out.print("플레이어 이름은(3 english letters)?: ");
        return sc.nextLine();
    }

    public static int score(int frame) {
        System.out.print(frame + "프레임 투구 : ");
        return Integer.parseInt(sc.nextLine());
    }
}
