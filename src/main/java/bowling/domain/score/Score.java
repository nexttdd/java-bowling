package bowling.domain.score;

public class Score {
    private int score;

    public Score(int score) {
        validate(score);
        this.score = score;
    }

    private void validate(int score) {
        if (score >= 0 && score <= 10) {
            return;
        }

        throw new IllegalArgumentException("outOfRange : " + score);
    }

    public int getScore() {
        return this.score;
    }
}
