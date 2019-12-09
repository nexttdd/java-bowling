package domain;

import utils.Consts;

public class Pin {
    int fallingNum;

    public Pin(int fallingNum) {
        this.fallingNum = fallingNum;
    }

    public static Pin of(int fallingNum) {
        if (fallingNum < Consts.SCORE_MIN_NUMBER || fallingNum > Consts.SCORE_MAX_NUMBER)
            throw new IllegalArgumentException();
        return new Pin(fallingNum);
    }

    public int getNumber() {
        return fallingNum;
    }

    public boolean isMin() {
        return fallingNum == Consts.SCORE_MIN_NUMBER;
    }

    public boolean isMax() {
        return fallingNum == Consts.SCORE_MAX_NUMBER;
    }
}
