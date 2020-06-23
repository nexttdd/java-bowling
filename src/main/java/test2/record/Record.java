package test2.record;

public interface Record {

    static Record ofPinCount(int pinCount) {
        if(Strike.isStrike(pinCount)) {//스트라이크냐?
            return Strike.getInstance();//스트라이크
        }

        if(Gutter.isGutter(pinCount)) {//거터냐?
            return Gutter.getInstance();//거터
        }

        return Miss.getInstance(pinCount);//미스
    }

    public static boolean isValid2(int numberOfPinHit){
        return false;
    }
    boolean isValid(int numberOfPinHit);
    int hitPinCount();
    String recordToString();
    Record nextRecord(int nextPinCount);
}