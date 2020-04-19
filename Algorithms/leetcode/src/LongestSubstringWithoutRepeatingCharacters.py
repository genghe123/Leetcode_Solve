# https://leetcode.com/problems/longest-substring-without-repeating-characters/ 

class Solution:
    def lengthOfLongestSubstring(self, s):
        if not s:
            return 0
        dic, res, start = {}, 0, 0
        for i, ch in enumerate(s):
            if ch in dic:
                res = max(res, i - start)
                start = max(start, dic[ch] + 1)
            dic[ch] = i
        return max(res, len(s) - start)
