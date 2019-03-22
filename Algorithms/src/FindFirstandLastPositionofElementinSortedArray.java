// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.ArrayList;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null ||nums.length==0|| nums[0] > target || nums[nums.length-1] < target) return result;

        int leftIndex = extremeInsertionIndex(nums, target, true);

        if (nums[leftIndex] != target) {
            return result;
        }

        int rightIndex = extremeInsertionIndex(nums, target, false);
        result[0] = leftIndex;
        result[1] = rightIndex-1;
        return result;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
