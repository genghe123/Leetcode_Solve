# https://leetcode.com/problems/single-number-ii/

# https://leetcode.com/problems/single-number-ii/discuss/43296/An-General-Way-to-Handle-All-this-sort-of-questions.


class Solution:
    def singleNumber(self, nums):
        a = b = 0
        for c in nums:
            tmpa = (a & ~b & ~c) | (~a & b & c)
            b = (~a & b & ~c) | (~a & ~b & c)
            a = tmpa
        return a | b


if __name__ == "__main__":
    sol = Solution()
    ans = sol.singleNumber([1, 2, 1, 2, 1, 2, 3])
    print(ans)