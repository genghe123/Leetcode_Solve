// https://leetcode.com/problems/unique-paths-ii/description/

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 1; i < m; i++) {
                dp[i][0] = (obstacleGrid[i - 1][0] == 1 || obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = (obstacleGrid[0][i - 1] == 1 || obstacleGrid[0][i] == 1) ? 0 : dp[0][i - 1];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j]) + (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
                }
            }
            return dp[m - 1][n - 1];
    }
}
