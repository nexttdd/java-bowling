package domain;

import java.util.HashMap;
import java.util.Map;

public enum Symbol {
    STRIKE(10, "X"),
    NUMBER_9(9, "9"),
    NUMBER_8(8, "8"),
    NUMBER_7(7, "7"),
    NUMBER_6(6, "6"),
    NUMBER_5(5, "5"),
    NUMBER_4(4, "4"),
    NUMBER_3(3, "3"),
    NUMBER_2(2, "2"),
    NUMBER_1(1, "1"),
    GETTER(0, "-");

    Symbol(int score, String specialCharacter) {
        this.score = score;
        this.specialCharacter = specialCharacter;
    }

    private int score;
    private String specialCharacter;

    private static final Map<Integer, String> symbols;

    static {
        symbols = new HashMap<>();
        Symbol[] symbols = Symbol.values();

        for (Symbol symbol : symbols) {
            Symbol.symbols.put(symbol.score, symbol.specialCharacter);
        }
    }


    public static String of(int score) {
        if (symbols.containsKey(score)) {
            return symbols.get(score);
        }
        throw new IllegalArgumentException();
    }
}
