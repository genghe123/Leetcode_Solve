// https://leetcode.com/problems/remove-boxes/description/

public class ReMoveBoxes {
    //todo understand how it uses three parameters to gain self-contained subproblem.
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub1(boxes, 0, n - 1, 0, dp);
    }

    private int removeBoxesSub1(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        // all boxes of the same color counted continuously from the first box should be
        // grouped together
        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++) ;
        int res = (k + 1) * (k + 1) + removeBoxesSub1(boxes, i + 1, j, 0, dp);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, removeBoxesSub1(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub1(boxes, m, j, k + 1, dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
