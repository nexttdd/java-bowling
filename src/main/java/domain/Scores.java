package domain;

import util.BowlingConst;

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

        //TODO : strike, spare 구분해서 add
        if (scores.size() < 1 && score == ScoreType.STRIKE.getScore()) {
            scores.add(ScoreType.STRIKE);
        } else {
            scores.add(ScoreType.of(score));
        }

        int sum = getSum();
        if (maxChance >= BowlingConst.NORMAL_CHANE && sum > BowlingConst.MAX_SCORE) {
            throw new IllegalArgumentException();
        }

        return this;
    }

    public int getChanceNumber() {
        return scores.size();
    }

    public boolean isEnd() {
        int sum = getSum();
        if (sum == BowlingConst.MAX_SCORE) {
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

    public boolean isSpare() {
        return scores.size() == BowlingConst.NORMAL_CHANE && getSum() == BowlingConst.MAX_SCORE;
    }

    @Override
    public String toString() {
        if(isSpare()){
            return scores.get(0).getSpecialCharacter() + "|" + ScoreType.SPARE.getSpecialCharacter();
        }

        return scores.stream()
                .map(score -> score.getSpecialCharacter())
                .collect(Collectors.joining("|"));
    }
}