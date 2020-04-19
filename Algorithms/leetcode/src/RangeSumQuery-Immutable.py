# https://leetcode.com/problems/range-sum-query-immutable/


class NumArray:
    sums = []

    def __init__(self, nums):
        n = len(nums)
        self.sums = [0] * (n + 1)
        accumlate = 0
        for i in range(n):
            accumlate += nums[i]
            self.sums[i + 1] = accumlate

    def sumRange(self, i, j):
        return self.sums[j + 1] - self.sums[i]


sol = NumArray([-2, 0, 3, -5, 2, -1])
print(sol.sumRange(0, 2))
print(sol.sumRange(2, 5))
print(sol.sumRange(0, 5))

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)