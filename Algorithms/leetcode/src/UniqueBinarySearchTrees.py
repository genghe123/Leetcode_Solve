# https://leetcode.com/problems/unique-binary-search-trees/


class Solution:
    # DP Solution
    def numTrees(self, n: int) -> int:
        dp = [0] * n
        dp[0] = 1
        for i in range(n + 1):
            for j in range(i):
                dp[i] += dp[j] * dp[i - 1 - j]
        return dp[n]

    # Catalan Number
    def numTrees2(self):
        n2 = math.factorial(2*n)
        n1 = math.factorial(n)
        ans = n2/n1/n1/(n+1)
        return int(ans)

# https://blog.csdn.net/qq_26525215/article/details/51453493