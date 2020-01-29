# https://leetcode.com/problems/counting-bits/


class Solution:
    def countBits(self, num):
        dp = [0] * (num + 1)
        for i in range(1, num + 1):
            dp[i]=(dp[i // 2] + (i & 1))
        return dp


if __name__ == "__main__":
    sol = Solution()
    res = sol.countBits(10)
    print(res)