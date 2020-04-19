// https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > n || nums[i] == nums[nums[i] - 1]) i++;
            else {
                swap(nums, i, nums[i] - 1);
            }
        }

        i = 0;
        while (i < n && nums[i] == i + 1) i++;
        return i + 1;
    }


    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
