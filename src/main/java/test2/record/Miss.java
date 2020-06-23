package test2.record;

import java.util.HashMap;
import java.util.Map;

public class Miss implements Record{

    private static final Map<Integer, Miss> reusableMiss = new HashMap<>();//재사용가능한미스<넘어뜨린갯수, 미스>

    private int pinCount;

    private Miss(int pinCount) {
        this.pinCount = pinCount;//핀갯수
    }

    public static Miss getInstance(int pinCount) {
        if(reusableMiss.get(pinCount) != null) {
            return reusableMiss.get(pinCount);
        }

        reusableMiss.put(pinCount, new Miss(pinCount));//넘어뜨린갯수에 핀더함
        return reusableMiss.get(pinCount);
    }

    @Override
    public boolean isValid(int numberOfPinHit) {
        return false;
    }

    @Override
    public int hitPinCount() {
        return this.pinCount;//친 갯수
    }

    @Override
    public String recordToString() {
        return String.valueOf(this.pinCount);// 갯수 표시
    }

    @Override
    public Record nextRecord(int nextPinCount) {
        int totalHitCount = this.hitPinCount() + nextPinCount;//넘어뜨린갯수 + 다음핀갯수

        if(Gutter.isGutter(nextPinCount)) {//다음핀갯수가 거터냐?
            return Gutter.getInstance();//거터다
        }

        if(Spare.isSpare(totalHitCount)) {//총 핀갯수가 스패어냐?
            return Spare.getInstance();//스패어다
        }

        return Miss.getInstance(nextPinCount);//다음핀갯수 반환
    }
}