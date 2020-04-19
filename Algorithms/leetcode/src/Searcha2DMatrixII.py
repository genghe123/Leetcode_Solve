# https://leetcode.com/problems/search-a-2d-matrix-ii/


class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        if target is None or not matrix: return False
        R, C = len(matrix), len(matrix[0])
        if R == 0 or C == 0: return False

        candidate = []
        for i in range(R):
            if matrix[i][0] <= target and matrix[i][C - 1] >= target:
                candidate.append(i)
        
        for i in candidate:
            if self.binarySearch(matrix[i],target):
                return True
        return False


    def binarySearch(self, array, target):
        if not array: return -1
        length = len(array)
        low, high = 0, length - 1
        while low < high:
            mid = (low+high)//2
            num = array[mid]
            if num < target: low = mid + 1
            elif num>target: high = mid-1
            else: return True
        return array[low] == target
                

if __name__ == "__main__":
    sol = Solution()
    sol.searchMatrix([[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],5)