// https://leetcode.com/problems/longest-increasing-subsequence/description/

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // Time complexity : O(n^2)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }

    // Time complexity : O(nlogn) Binary Search
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];

        //todo
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        l.lengthOfLIS2(nums);
    }
}
