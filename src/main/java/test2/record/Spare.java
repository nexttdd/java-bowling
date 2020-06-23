package test2.record;

import static test2.BowlingConstants.MAX_HIT;

public class Spare implements Record {

    private static final String SPARE = "/";//스패어

    private static Spare spare = new Spare();//스패어생성자

    private Spare() {
    }

    public static Spare getInstance() {//스패어 싱글턴
        return spare;
    }

    public static boolean isSpare(int numberOfPinHit) {
        if(numberOfPinHit > MAX_HIT) {//친수가 최대갯수가 넘냐
            throw new IllegalArgumentException("볼링핀의 합계는 1~10 사이의 값임");
        }
        return numberOfPinHit == MAX_HIT;
    }

    @Override
    public boolean isValid(int numberOfPinHit) {
        if(numberOfPinHit > MAX_HIT) {//친수가 최대갯수가 넘냐
            throw new IllegalArgumentException("볼링핀의 합계는 1~10 사이의 값임");
        }
        return numberOfPinHit == MAX_HIT;
    }

    @Override
    public int hitPinCount() {
        return MAX_HIT;//친갯수
    }

    @Override
    public String recordToString() {
        return SPARE;//표시
    }

    @Override
    public Record nextRecord(int nextPinCount) {
        return Record.ofPinCount(nextPinCount);//다음 표시상태
    }
}