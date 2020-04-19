# https://leetcode.com/problems/rotate-image/

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        matrix.reverse()
        # transpose
        for i in range(n):
            for j in range(i+1, n):
            # for j in range(i):
                tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
        return matrix

    def rotate2(self, matrix):
        matrix[::] = zip(*matrix[::-1])