package test2;

import org.junit.Assert;
import org.junit.Test;
import test2.record.*;
import test2.record.Gutter;
import test2.record.Miss;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {
    @Test
    public void 스트라이크인_경우() {
        Record result = Record.ofPinCount(10);
        assertEquals(result, Strike.getInstance());
    }


    @Test
    public void 스페어인_경우() {
        Record result = Record.ofPinCount(9).nextRecord(1);
        Assert.assertEquals(result, Spare.getInstance());
    }

    @Test
    public void 미스인_경우() {
        Record result = Record.ofPinCount(5);
        Assert.assertEquals(result, Miss.getInstance(5));
    }

    @Test
    public void 거터인_경우() {
        Record result = Record.ofPinCount(0);
        Assert.assertEquals(result, Gutter.getInstance());
    }
}