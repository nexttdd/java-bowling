package domain;

public class NormalFrame {
    //TODO : 투구, player 이름 저장, scores 객체 생성

    private Player player;
    private Scores scores;

    public NormalFrame(Player player) {
        this.player = player;
        scores = new Scores(2);
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
