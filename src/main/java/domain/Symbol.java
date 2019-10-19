package domain;

import java.util.HashMap;
import java.util.Map;

public enum Symbol {
    STRIKE(10, "X");

    Symbol(int score, String specialCharacter) {
        this.score = score;
        this.specialCharacter = specialCharacter;
    }

    private int score;
    private String specialCharacter;

    private static final Map<Integer, String> symbols;

    static {
        symbols = new HashMap<>();
        Symbol[] symbols22 = Symbol.values();

        for (Symbol symbol : symbols22) {
            symbols.put(symbol.score, symbol.specialCharacter);
        }
    }


    public static String of(int score) {
        if (symbols.containsKey(score)) {
            return symbols.get(score);
        }

        return Integer.toString(score);
    }
}
