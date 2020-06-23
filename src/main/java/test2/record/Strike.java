package test2.record;

import static test2.BowlingConstants.MAX_HIT;

public class Strike implements Record {

    private static final String STRIKE = "X";

    private static Strike strike = new Strike();//생성자

    private Strike() {
    }

    public static Strike getInstance() {//싱글톤
        return strike;
    }

    public static boolean isStrike(int pinCount) {//스트라이크냐?
        return pinCount == MAX_HIT;
    }

    @Override
    public boolean isValid(int numberOfPinHit) {
        return numberOfPinHit == MAX_HIT;
    }

    @Override
    public int hitPinCount() {
        return MAX_HIT;
    }

    @Override
    public String recordToString() {
        return STRIKE;
    }

    @Override
    public Record nextRecord(int nextPinCount) {
        return Record.ofPinCount(nextPinCount);
    }
}