import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingPositiveTest {

    private FirstMissingPositive f = new FirstMissingPositive();

    @Test
    public void firstMissingPositive() {
        assertEquals(3, f.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, f.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, f.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        assertEquals(2, f.firstMissingPositive(new int[]{1,1}));
    }
}