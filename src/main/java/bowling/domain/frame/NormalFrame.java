package bowling.domain.frame;

import bowling.domain.score.Scores;

public class NormalFrame implements Frame {
    private String playerName;
    private Scores scores;

    private NormalFrame(String playerName) {
        this.playerName = playerName;
        this.scores = new Scores(2);
    }

    public static NormalFrame of(String playerName) {
        return new NormalFrame(playerName);
    }

    @Override
    public void play(int pins) {
        scores.normalRegister(pins);
    }

    @Override
    public boolean isEnd() {
        return scores.isNormalFrameEnd();
    }

    @Override
    public Scores getScores() {
        return this.scores;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public String toString() {
        return scores.toString() + " |";
    }
}
