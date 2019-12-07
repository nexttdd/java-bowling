package bowling.domain.score;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    private int maxRegisterCount;
    private List<Score> scores;

    public Scores(int maxPlayCount) {
        if (maxPlayCount != 2 && maxPlayCount != 3) {
            throw new IllegalArgumentException("wrong maxPlayCount");
        }

        scores = new ArrayList<>();
        maxRegisterCount = maxPlayCount;
    }

    public void finalRegister(int playScore) {
        if (isFinalFrameEnd()) {
            throw new IllegalArgumentException();
        }

        register(playScore);
    }

    public void normalRegister(int playScore) {
        if (isNormalFrameEnd()) {
            throw new IllegalArgumentException();
        }

        register(playScore);
    }

    private void register(int playScore) {
        scores.add(new Score(playScore));

        if (!checkTotalScore()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNormalFrameEnd() {
        return maxRegisterCount == scores.size() || isStrike();
    }

    public boolean isFinalFrameEnd() {
        if (scores.size() == 2) {
            return isSpare() == Boolean.FALSE;
        }

        //size가 3인 경우
        return scores.size() == maxRegisterCount;
    }

    public boolean checkTotalScore() {
        int totalScore = sumOfScore();

        if (maxRegisterCount == 2 && totalScore <= 10) {
            return true;
        }

        if (maxRegisterCount == 3 && totalScore <= 30) {
            return true;
        }

        return false;
    }

    public int sumOfScore() {
        int sum = 0;
        for (Score score : scores) {
            sum += score.getScore();
        }

        return sum;
    }

    public List<Score> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        if (scores.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0 ; i < scores.size()-1 ; i++ ) {
            sb.append(scores.get(i).getScore());
            sb.append("|");
        }

        sb.append(scores.get(scores.size()-1));

        return sb.toString();
    }

    public boolean isStrike() {
        return scores.size() == 1 && sumOfScore() == 10;
    }

    public boolean isSpare() {
        //TODO : final Frame오류  10/0 => spare로 판단
        return scores.size() == 2 && sumOfScore() == 10;
    }
}
