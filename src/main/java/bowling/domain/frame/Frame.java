package bowling.domain.frame;

import bowling.domain.score.Scores;

public interface Frame {
    void play(int playScore);
    Scores getScores();
    boolean isEnd();
}
