// https://leetcode.com/problems/search-insert-position/description/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compared = Integer.compare(target, nums[mid]);
            if (compared == 0) return mid;
            if (compared < 0) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
