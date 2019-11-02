package domain;

import java.util.HashMap;
import java.util.Map;

public enum ScoreType {
    STRIKE(10, "X"),
    SPARE(10, "/"),
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

    ScoreType(int score, String specialCharacter) {
        this.score = score;
        this.specialCharacter = specialCharacter;
    }

    private int score;
    private String specialCharacter;

    private static final Map<Integer, ScoreType> scoreTypes;

    static {
        scoreTypes = new HashMap<>();
        ScoreType[] scoreTypes = ScoreType.values();

        for (ScoreType scoreType : scoreTypes) {
            ScoreType.scoreTypes.put(scoreType.score, scoreType);
        }
    }


    public static ScoreType of(int score) {
        if (scoreTypes.containsKey(score)) {
            return scoreTypes.get(score);
        }
        throw new IllegalArgumentException();
    }

    public int getScore() {
        return score;
    }

    public String getSpecialCharacter() {
        return specialCharacter;
    }
}
