import org.junit.Test;


import static org.junit.Assert.*;

public class HappyNumberTest {

    private HappyNumber happyNumber = new HappyNumber();

    @Test
    public void isHappy() {
        assertTrue(happyNumber.isHappy(19));
        assertTrue(happyNumber.isHappy(7));
        assertTrue(happyNumber.isHappy(1));
        assertFalse(happyNumber.isHappy(2));
        int num = 0;
        for (int i = 0; i <= 99; i++) {
            if (happyNumber.isHappy(i)) num++;
        }
        assertEquals(19, num);
    }
}