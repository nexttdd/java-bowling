package bowling.util;

import bowling.domain.frame.Frame;
import bowling.domain.score.Score;
import bowling.domain.score.Scores;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class DisplayUtil {
    private static final int WIDTH = 7;
    private static final String SPLIT = "|";
    private static final String EMPTY = "";

    public static String playerResult(List<Frame> frames, String player) {
        StringBuilder sb = new StringBuilder();
        sb.append(SPLIT + StringUtils.center(player, WIDTH) + SPLIT);

        for (Frame frame : frames) {
            String result = StringUtils.center(frameScore(frame.getScores()), WIDTH);
            sb.append( result + SPLIT);
        }

        return sb.toString();
    }

    public static String frameScore(Scores scores) {
        List<Score> scoreList = scores.getScores();
        if (scoreList.isEmpty()) {
            return StringUtils.center(EMPTY, WIDTH);
        }

        return DisplayType.getChar(scores.sumOfScore(), scoreList);
    }
}
