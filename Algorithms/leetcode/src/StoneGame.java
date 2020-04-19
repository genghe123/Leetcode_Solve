// https://leetcode.com/problems/stone-game/description/
// https://leetcode.com/problems/predict-the-winner/description/
// https://www.nowcoder.com/questionTerminal/7036f62c64ba4104a28deee98a6f53f6

public class StoneGame {
    /* 用F[l][r]表示先选的人能拿到的最高分
       用S[l][r]来表示后选的人能拿到的最高分
       如对于一组从0,1,2，...,n-1的数对于先选者，他有两种选法
       若先选者选A[0],则对于后面的1，...,n-1数组，他就变成了后选者，此时能拿到的分为A[0]+S[1][n-1]
       若先选者选A[n-1],则对于前面的数组0，...，n-2,同样变为后选者，此时能拿到得分为A[n-1]+S[0][n-2];
       所以 F[0][n-1]=max(A[0]+S[1][n-1],A[n-1]+S[0][n-2])

       对于后选者，他能能到的最高分是受先选者控制的，即他只能选到先选者留给他的最小值，
       将其转化为数学形式就是S[l][r]=min(F[l+1][r],F[l][r-1]);
       这里的最小值是先选者留给他的，他只能拿到最小值*/
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int j = 0; j < N; j++) {
            f[j][j] = piles[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(piles[i] + s[i + 1][j], piles[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][N - 1] - s[0][N - 1] > 0;
    }

    // piles.length is always even.
    public boolean stoneGame2(int[] piles) {
        return true;
    }

    public boolean stoneGame3(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N + 2][N + 2];
        for (int size = 1; size <= N; size++) {
            for (int i = 0; i + size <= N; i++) {
                int j = i + size - 1;
                int parity = (N - (j - i)) % 2; // (N - (j - i + 1) + 1)
                // parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1) {
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                } else {
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
                }
            }
        }

        return dp[1][N] > 0;
    }
}
