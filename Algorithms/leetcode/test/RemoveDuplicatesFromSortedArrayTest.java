import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();

    public int[] dealed(int[] nums) {
        int length = remove.removeDuplicates(nums);
        return Arrays.copyOf(nums, length);
    }

    @Test
    public void removeDuplicates() {
        assertEquals(2, remove.removeDuplicates(new int[]{1, 1, 2}));
        assertEquals(3, remove.removeDuplicates(new int[]{2, 1, 1, 0, 0, 0}));
        assertEquals(0, remove.removeDuplicates(new int[]{ }));

        assertArrayEquals(new int[]{1, 2}, dealed(new int[]{1, 1, 2}));
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, dealed(new int[]{5, 5, 4, 4, 4, 3, 2, 2, 2, 2, 2, 2, 2, 1, 1}));

    }
}