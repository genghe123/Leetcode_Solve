# https://leetcode.com/problems/search-a-2d-matrix/


class Solution:
    def searchMatrix(self, matrix, target):
        if not matrix or target is None: return False

        R, C = len(matrix), len(matrix[0])
        if R == 0 or C == 0: return False
        left, right = 0, R * C - 1
        while left < right:
            mid = left + (right - left) // 2
            r, c = mid // C, mid % C
            num = matrix[r][c]
            if num < target:
                left = mid + 1
            elif num > target:
                right = mid - 1
            else:
                return True
        r, c = left // C, left % C
        return matrix[r][c] == target


if __name__ == "__main__":
    sol = Solution()
    # ans = sol.searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]],
    #                        3)
    ans = sol.searchMatrix([[]], 0)
    print(ans)
