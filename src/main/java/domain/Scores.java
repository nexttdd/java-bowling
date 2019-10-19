package domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    private List<ScoreType> scores;

    public Scores(int chance) {
        scores = new ArrayList<>(chance);
    }

    public int getChanceNumber() {
        return scores.size();
    }
}
