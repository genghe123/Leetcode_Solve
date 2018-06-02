// https://leetcode.com/problems/move-zeroes/description/

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int p1, p2 = 0;
        for (p1 = 0; p1 < nums.length; p1++) {
            if (nums[p1] == 0) continue;
            nums[p2++] = nums[p1];
        }
        for (; p2 < nums.length; p2++) {
            nums[p2] = 0;
        }
    }
}
