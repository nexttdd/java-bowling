package bowling.domain.frame;

import bowling.domain.score.Scores;

public class FinalFrame implements Frame {
    private String playerName;
    private Scores scores;

    private FinalFrame(String playerName) {
        this.playerName = playerName;
        this.scores = new Scores(3);
    }

    public static FinalFrame of(String playerName) {
        return new FinalFrame(playerName);
    }

    @Override
    public void play(int playScore) {
        scores.finalRegister(playScore);
    }

    @Override
    public boolean isEnd() {
        return scores.isFinalFrameEnd();
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
