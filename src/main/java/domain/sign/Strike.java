package domain.sign;

import domain.Pin;
import utils.Consts;

public class Strike implements Record {
    public static boolean isMatch(Pin pin) {
        return pin.isMax();
    }

    @Override
    public String getSpecialCharacter() {
        return Consts.SIGN_STRIKE;
    }
}
