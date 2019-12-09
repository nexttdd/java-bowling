package domain.sign;

import domain.Pin;

public interface Record {
    static Record of(Pin pin) {
        if (Strike.isMatch(pin)) {
            return new Strike();
        }
        if(Gutter.isMatch(pin)){
            return new Gutter();
        }

        return new Miss();
    }

    String getSpecialCharacter();
}
