// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] cnt = new int[nums.length];
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max == len[i]) res += cnt[i];
            else if (max < len[i]) {
                max = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 4, 7};
        NumberofLongestIncreasingSubsequence n = new NumberofLongestIncreasingSubsequence();
        n.findNumberOfLIS(a);
    }
}
