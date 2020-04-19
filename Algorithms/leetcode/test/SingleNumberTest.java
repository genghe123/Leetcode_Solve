import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberTest {

    private SingleNumber singleNumber = new SingleNumber();

    @Test
    public void singleNumber() {
        assertEquals(1, singleNumber.singleNumber(new int[]{1}));
        assertEquals(1, singleNumber.singleNumber(new int[]{2,1,2}));

    }
}