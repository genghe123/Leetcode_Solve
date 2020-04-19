# https://leetcode.com/problems/largest-rectangle-in-histogram/
# Related topic
# https://leetcode.com/problems/trapping-rain-water/

class Solution:
    def largestRectangleArea(self, heights):
        if not heights or len(heights) <= 0:
            return 0
        heights.append(0)
        res = 0
        stack = [-1]

        for i in range(0, len(heights)):
            while heights[i] < heights[stack[-1]]:
                h = heights[stack.pop()] 
                w = i - stack[-1] - 1
                res = max(res, w * h)
            stack.append(i)
        heights.pop()
        return res

sol = Solution()
# print(sol.largestRectangleArea([2,1,5,6,2,3]))
print(sol.largestRectangleArea([2,2,5,6,2,3]))
print(sol.largestRectangleArea([2,2,100,100,2,3]))
