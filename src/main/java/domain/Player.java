package domain;

import org.apache.commons.lang3.StringUtils;

public class Player {

    private static final int NAME_LENGTH = 3;
    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        if(name.length() != NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        return new Player(name);
    }

    @Override
    public String toString() {
        return "|"+ StringUtils.center(name, 5);

    }
}
