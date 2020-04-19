// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int position = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[position]) continue;
            nums[++position] = nums[i];
        }
        return position + 1;
    }
}
