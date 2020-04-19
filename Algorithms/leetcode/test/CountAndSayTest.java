import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountAndSayTest {

    private CountAndSay countAndSay = new CountAndSay();

    @Test
    public void countAndSay() {
        assertEquals("1", countAndSay.countAndSay(1));
        assertEquals("11", countAndSay.countAndSay(2));
        assertEquals("21", countAndSay.countAndSay(3));
        assertEquals("1211", countAndSay.countAndSay(4));
        assertEquals("111221", countAndSay.countAndSay(5));
        assertEquals("312211", countAndSay.countAndSay(6));
        assertEquals("13112221", countAndSay.countAndSay(7));

    }
}