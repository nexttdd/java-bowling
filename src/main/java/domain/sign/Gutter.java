package domain.sign;

import domain.Pin;
import utils.Consts;

public class Gutter implements Record {
    public static boolean isMatch(Pin pin){
        return pin.isMin();
    }

    @Override
    public String getSpecialCharacter() {
        return Consts.SIGN_GUTTER;
    }
}
