import org.junit.Test;

import static org.junit.Assert.*;

public class DivideTwoIntegersTest {

    private DivideTwoIntegers divide = new DivideTwoIntegers();

    @Test
    public void divide() {
        assertEquals(3,divide.divide(10,3));
        assertEquals(-1,divide.divide(10,0));
        assertEquals(-2,divide.divide(7,-3));
        assertEquals(1,divide.divide(-1,-1));
        assertEquals(-1,divide.divide(-1,1));
        assertEquals(2147483647,divide.divide(-2147483648,-1));
    }

    @Test(timeout = 1000)
    public void divideTime(){
        assertEquals(2147483647,divide.divide(-2147483648,-1));
    }
}