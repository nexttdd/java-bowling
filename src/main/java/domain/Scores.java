package domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    private final List<ScoreType> scores;
    private int resultNumber;
    private int maxChance;

    public Scores(int chance) {
        this.maxChance = chance;
        scores = new ArrayList<>(chance);
    }

    public void register(int score) {
        if (scores.size() == maxChance) {
            throw new ArrayIndexOutOfBoundsException();
        }

        scores.add(ScoreType.of(score));

        if (scores.size() >= 2) {
            for (ScoreType type : scores) {
                resultNumber += type.getScore();
            }
        }

        if (maxChance >= 2 && resultNumber > 10) {
            throw new IllegalArgumentException();
        }
    }

    public int getChanceNumber() {
        return scores.size();
    }

    public int getResultNumber() {
        return resultNumber;
    }
}