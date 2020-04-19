# https://leetcode.com/problems/reverse-string/


class Solution:
    def reverseString(self, s):
        """
        Do not return anything, modify s in-place instead.
        """
        if not s or s is None:
            return

        i, j = 0, len(s) - 1
        while i < j:
            c = s[i]
            s[i] = s[j]
            s[j] = c
            i += 1
            j -= 1


sol = Solution()
str = ["H", "a", "n", "n", "a", "h"]
sol.reverseString(str)
print(str)