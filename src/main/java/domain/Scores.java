package domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    private final List<ScoreType> scores;

    public Scores(int chance) {
        scores = new ArrayList<>(chance);
    }

    public void register(int score) {
//        if (scores.size() > 2) {
//            throw new ArrayIndexOutOfBoundsException();
//        }

        scores.add(ScoreType.of(score));
    }

    public int getChanceNumber() {
        return scores.size();
    }
}
