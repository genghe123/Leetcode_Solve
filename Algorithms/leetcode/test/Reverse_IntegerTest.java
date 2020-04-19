import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Reverse_IntegerTest {
    ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    public void reverse() {
        assertEquals(321, reverseInteger.reverse(123));
        assertEquals(-321, reverseInteger.reverse(-123));
        assertEquals(21, reverseInteger.reverse(120));
        assertEquals(1, reverseInteger.reverse(100));
        assertEquals(-1, reverseInteger.reverse(-100));
        assertEquals(0, reverseInteger.reverse(1534236469));

    }
}