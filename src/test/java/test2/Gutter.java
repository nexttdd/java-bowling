package test2;

import test2.record.Record;

public class Gutter implements Record {
    private static test2.record.Gutter gutter = new test2.record.Gutter();

    public static test2.record.Gutter getInstance() {
        return gutter;
    }

    @Override
    public int hitPinCount() {
        return 0;
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
