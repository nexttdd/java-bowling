package test2.record;

import static test2.BowlingConstants.MIN_HIT;

public class Gutter implements Record {

    private static final String GUTTER = "-";//거터

    private static Gutter gutter = new Gutter();//거터 생성

    private Gutter() {
    }

    public static Gutter getInstance() {//거터 싱글톤 반환
        return gutter;
    }

    public static boolean isGutter(int pinCount) {//거터냐?
        return pinCount == MIN_HIT;
    }

    @Override
    public boolean isValid(int numberOfPinHit) {
        return numberOfPinHit == MIN_HIT;
    }

    @Override
    public int hitPinCount() {
        return MIN_HIT;//최소 핀갯수
    }

    @Override
    public String recordToString() {
        return GUTTER;//거터
    }

    @Override
    public Record nextRecord(int nextPinCount) {
        int totalHitCount = this.hitPinCount() + nextPinCount;// 친갯수 + 다음 갯수

        if(Gutter.getInstance().isValid(nextPinCount)) {//다음 갯수가 거터냐?
            return Gutter.getInstance();//거터다
        }

        if(Spare.isSpare(totalHitCount)) {//총 넘어트린게 스패어냐?
            return Spare.getInstance();//스패어다
        }

        return Miss.getInstance(nextPinCount);//미스인스턴스
    }
}
