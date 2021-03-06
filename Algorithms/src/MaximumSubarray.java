// https://leetcode.com/problems/maximum-subarray/description/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        int max = nums[0];
        dp[0] = max;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
