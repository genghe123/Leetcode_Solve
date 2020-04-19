// https://leetcode.com/problems/remove-element/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[position++] = nums[i];
        }
        return position;
    }
}
