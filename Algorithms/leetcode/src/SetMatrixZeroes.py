# https://leetcode.com/problems/set-matrix-zeroes/


class Solution:
    def setZeroes(self, matrix):
        """
        Do not return anything, modify matrix in-place instead.
        """

        if len(matrix) == 1 and len(matrix[0]) == 1:
            return

        x, y = -1, -1
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0:
                    if x == -1:
                        x, y = (row, col)
                    print(x)
                    matrix[x][col] = 0
                    matrix[row][y] = 0

        if x != -1:
            for row in range(len(matrix)):
                for col in range(len(matrix[0])):
                    if row != x and col != y and (matrix[x][col] == 0
                                                  or matrix[row][y] == 0):
                        matrix[row][col] = 0

            for row in range(len(matrix)):
                matrix[row][y] = 0

            for col in range(len(matrix[0])):
                matrix[x][col] = 0

    # https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
    def setZeroes2(self, matrix):
        # First row has zeros?
        m, n, firstRowHasZero = len(matrix), len(matrix[0]), not all(matrix[0])

        # Use first row/column as marker, scan the matrix
        for i in range(1, m):
            for j in range(n):
                if matrix[i][j] == 0:
                    matrix[0][j] = matrix[i][0] = 0

        # Set the zeros
        for i in range(1, m):
            for j in range(n - 1, -1, -1):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0

        # Set the zeros for the first row
        if firstRowHasZero:
            matrix[0] = [0] * n


if __name__ == "__main__":
    sol = Solution()
    matrix = [[-1], [2], [3]]
    sol.setZeroes(matrix)
    print(matrix)