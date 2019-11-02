package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scores {

    private final List<ScoreType> scores;
    private int maxChance;

    public Scores(int chance) {
        this.maxChance = chance;
        scores = new ArrayList<>(chance);
    }

    public Scores register(int score) {
        if (scores.size() == maxChance) {
            throw new ArrayIndexOutOfBoundsException();
        }

        scores.add(ScoreType.of(score));

        int sum = getSum();
        if (maxChance >= 2 && sum > 10) {
            throw new IllegalArgumentException();
        }

        return this;
    }

    public int getChanceNumber() {
        return scores.size();
    }

    public boolean isEnd() {
        int sum = getSum();
        if (sum == 10) {
            return true;
        }

        if (scores.size() == maxChance) {
            return true;
        }

        return false;
    }

    public int getSum() {
        return scores.stream()
                .mapToInt(score -> score.getScore())
                .sum();
    }

    @Override
    public String toString() {
        return scores.stream()
                .map(score -> score.getSpecialCharacter())
                .collect(Collectors.joining("|"));
    }
}