package domain;

public class NormalFrame {
    //TODO : 투구, player 이름 저장, scores 객체 생성

    private String playerName;
    private Scores scores;

    public NormalFrame(String playerName) {
        this.playerName = playerName;
        scores = new Scores(2);
    }

    public void play(int score) {
        scores.register(score);
    }

    public String getPlayerName() {
        return playerName;
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
