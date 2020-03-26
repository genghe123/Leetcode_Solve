#https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/


class Solution:
    def removeDuplicates(self, nums):
        if not nums or len(nums) == 1:
            return
        cnt, newPos = 1, 1
        value = nums[0]

        for i in range(1, len(nums)):
            if nums[i] == value:
                cnt += 1
            else:
                cnt = 1
                value = nums[i]
            if cnt <= 2:
                nums[newPos] = nums[i]
                newPos += 1
            print(cnt, newPos, i)

        return newPos


if __name__ == "__main__":
    sol = Solution()
    nums = [1,1,1,2,2,3]
    number = sol.removeDuplicates(nums)
    print(number)
    print(nums)