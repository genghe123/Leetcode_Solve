# https://leetcode.com/problems/trapping-rain-water/

class Solution:
    # Two pointer
    def trap(self, height):
        if not height or len(height) <= 2:
            return 0
        res = 0
        length = len(height)
        left, right = 1, length-2
        max_left, max_right = height[0], height[-1]
        while left <= right:
            if max_left < max_right:
                res += max(0, max_left - height[left])
                max_left = max(max_left, height[left])
                left += 1
            else:
                res += max(0, max_right - height[right])
                max_right = max(max_right, height[right])
                right -= 1
        return res

    # DP
    def trap2(self, height):
        if not height or len(height) <= 2:
            return 0
        res = 0
        length = len(height)
        max_from_left = [0] * length
        max_from_right = [0] * length
        max_from_left[0] =height[0]
        max_from_right[length-1] = height[-1]
        for i in range(1, length):
            max_from_left[i] = max(max_from_left[i-1], height[i])
        for i in range(length-2, -1, -1):
            max_from_right[i] = max(max_from_right[i+1], height[i])
        for i in range(1, length-1):
            min_barrier = min(max_from_left[i], max_from_right[i])
            if min_barrier > height[i]:
                res += min_barrier - height[i]
        return res

    # Stack
    def trap3(self, height):
        if not height or len(height) <= 2:
            return 0
        length = len(height)

        stack = []
        res = 0
        for i in range(0, length):
            while len(stack) > 0 and height[i] > height[stack[-1]]:
                h = height[stack.pop()]
                if len(stack) == 0:
                    break
                distance = i - stack[-1] - 1
                min_bar = min(height[stack[-1]], height[i])
                res += distance * (min_bar - h)
            stack.append(i)
        return res

sol = Solution()
print(sol.trap2( [0,1,0,2,1,0,1,3,2,1,2,1]))
print(sol.trap2( [2,0,2]))
