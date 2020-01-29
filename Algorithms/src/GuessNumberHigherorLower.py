# https://leetcode.com/problems/guess-number-higher-or-lower/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china

# The guess API is already defined for you.
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:


class Solution:
    def guessNumber(self, n: int) -> int:
        l, r = 1, 1

        while r:
            c = l + (n - l) // 2
            r = guess(c)
            if r < 0:
                n = c - 1
            else:
                l = c + 1

        return c