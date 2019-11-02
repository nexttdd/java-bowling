package domain;

import util.BowlingConst;

public class NormalFrame {
    private Player player;
    private Scores scores;

    public NormalFrame(Player player) {
        this.player = player;
        scores = new Scores(BowlingConst.NORMAL_CHANE);
    }

    public Scores play(int score) {
        return scores.register(score);
    }

    public Player getPlayer() {
        return player;
    }

    public Scores getScores() {
        return scores;
    }

    public int getTotalScore() {
        return scores.getSum();
    }

    public boolean isEnd() {
        return scores.isEnd();
    }
}
