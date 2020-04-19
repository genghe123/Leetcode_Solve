// https://leetcode.com/problems/predict-the-winner/description/
// https://leetcode.com/problems/stone-game/description/
// https://www.nowcoder.com/questionTerminal/7036f62c64ba4104a28deee98a6f53f6

public class PredicttheWinner {
    public boolean PredictTheWinner1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int length = nums.length;
        // 当length为偶数时先手一定赢，如果仅有一个数，先手一定赢
        if (length % 2 == 0 || length == 1) return true;
        int[][] f = new int[length][length];
        int[][] s = new int[length][length];

        for (int j = 0; j < length; j++) {
            f[j][j] = nums[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(nums[i] + s[i + 1][j], nums[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][length - 1] - s[0][length - 1] > 0;
    }

    //todo understand
    public boolean PredictTheWinner2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length + 1][length];
        for (int i = nums.length; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                int a = nums[i] - dp[i + 1][j];
                int b = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(a, b);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
