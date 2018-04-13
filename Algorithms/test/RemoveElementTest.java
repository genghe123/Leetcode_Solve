import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveElementTest {

    private RemoveElement removeElement = new RemoveElement();

    public int[] dealed(int[] nums, int val) {
        int length = removeElement.removeElement(nums, val);
        return Arrays.copyOf(nums, length);
    }

    @Test
    public void removeElement() {
        assertEquals(2, removeElement.removeElement(new int[]{3, 2, 2, 3}, 3));
        assertEquals(5, removeElement.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

        assertArrayEquals(new int[]{0, 1, 3, 0, 4}, dealed(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

    }
}