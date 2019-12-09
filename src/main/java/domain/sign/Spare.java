package domain.sign;

import utils.Consts;

public class Spare implements Record {
    @Override
    public String getSpecialCharacter() {
        return Consts.SIGN_SPARE;
    }
}
