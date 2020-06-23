package test2;

import test2.record.Record;

import java.util.HashMap;
import java.util.Map;

public class Miss implements Record {

    private  static final Map<Integer, test2.record.Miss> reusableMiss = new HashMap();
    private int pintCount;

    public Miss(int pintCount) {
        this.pintCount = pintCount;
    }

    public static test2.record.Miss getInstance(int pinCount) {
        if(reusableMiss.get(pinCount) != null){
            return reusableMiss.get(pinCount);
        }

        test2.record.Miss miss = new test2.record.Miss(pinCount);
        reusableMiss.put(pinCount, miss);
        return reusableMiss.get(pinCount);
    }

    @Override
    public int hitPinCount() {
        return this.pintCount;
    }

    @Override
    public String recordToString() {
        return null;
    }

    @Override
    public Record nextRecord(int nextPinCount) {
        return null;
    }
}
