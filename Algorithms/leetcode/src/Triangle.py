# https://leetcode.com/problems/triangle/

import sys


class Solution:
    def minimumTotal(self, triangle):
        n = len(triangle)
        if n == 0:
            return 0
        elif n == 1:
            return triangle[0][0]

        dp = [[sys.maxsize] * n, [sys.maxsize] * n]
        dp[0][0] = triangle[0][0]

        for i in range(1, n):
            dpOld = dp[(i + 1) % 2]
            dpNew = dp[i % 2]
            for j in range(i + 1):
                aboveLeft = sys.maxsize if j == 0 else dpOld[j - 1]
                aboveRight = sys.maxsize if j == i else dpOld[j]
                minAbove = min(aboveLeft, aboveRight)
                dpNew[j] = minAbove + triangle[i][j]
        return min(dpNew)

    # todo important
    # bottom-up, O(n) space
    def minimumTotal1(self, triangle):
        if not triangle:
            return
        n = len(triangle)

        res = triangle[-1]
        for i in range(n - 2, -1, -1):
            for j in range(len(triangle[i])):
                res[j] = min(res[j], res[j + 1]) + triangle[i][j]
        return res[0]


if __name__ == "__main__":
    sol = Solution()
    triangle = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    resp = sol.minimumTotal(triangle)
    print(resp)