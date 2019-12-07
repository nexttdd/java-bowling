package domain;

import utils.Consts;

public class Pin {
    int fallingNum;

    public Pin(int fallingNum) {
        this.fallingNum = fallingNum;
    }

    public static Pin of(int fallingNum) {
        if(fallingNum < Consts.NUMBER_INITIAL_FRAME || fallingNum > Consts.NUMBER_FINAL_FRAME)
            throw new IllegalArgumentException();
        return new Pin(fallingNum);
    }

    public int getNumber() {
        return fallingNum;
    }
}
