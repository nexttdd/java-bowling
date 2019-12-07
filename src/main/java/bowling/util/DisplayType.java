package bowling.util;

import bowling.domain.score.Score;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public enum DisplayType {
    STRIKE  ("X", 10),
    SPARE   ("/", 10),
    NINE    ("9", 9),
    EIGHT   ("8", 8),
    SEVEN   ("7", 7),
    SIX     ("6", 6),
    FIVE    ("5", 5),
    FOUR    ("4", 4),
    THREE   ("3", 3),
    TWO     ("2", 2),
    ONE     ("1", 1),
    GUTTER  ("-", 0);

    private String character;
    private int score;

    private static final Map<Integer, String> types;
    static {
        types = new HashMap<>();
        Stream.of(DisplayType.values())
                .forEach(displayType -> {
                    if(displayType.score !=10) {
                        types.put(displayType.score, displayType.character);
                    }
                });
    }

    DisplayType(String character, int score) {
        this.character = character;
        this.score = score;
    }

    //
    public static String getChar(int frameScore, List<Score> scores) {
        int[] scoreList = new int[scores.size()];
        for (int i = 0; i < scores.size(); i++) {
            scoreList[i] = scores.get(i).getScore();
        }

        List<String> chars = convertToChars(scoreList, frameScore);
        return StringUtils.join(chars, "|");
    }

    //normal case
    public static String getChar(int frameScore, int... scores) {
        List<String> chars = convertToChars(scores, frameScore);

        return StringUtils.join(chars, "|");
    }

    private static List<String> convertToChars(int[] scores, int frameScore) {
        List<String> chars = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            chars.add(getChar(scores[i], i, frameScore));
        }

        return chars;
    }

    private static String getChar(int score, int time, int frameScore) {
        //strike
        if (time != 1 && score == 10) {
            return STRIKE.character;
        }

        //spare
        if (time == 1 && frameScore == 10) {
            return SPARE.character;
        }

        return types.get(score);
    }
}
