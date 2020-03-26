# https://leetcode.com/problems/range-sum-query-2d-immutable/


class NumMatrix:

    sums = []

    def __init__(self, matrix):
        if matrix is None or not matrix:
            return
        row, col = len(matrix), len(matrix[0])
        self.sums = [[0] * (col + 1) for x in range(row + 1)]

        acc = 0
        for i in range(row):
            for j in range(col):
                sumAbove = self.sums[i][j + 1]
                acc += matrix[i][j]
                self.sums[i + 1][j + 1] = sumAbove + acc
            acc = 0

        print(self.sums)

    def sumRegion(self, row1, col1, row2, col2):
        return self.sums[row2 + 1][col2 + 1] - self.sums[row1][
            col2 + 1] - self.sums[row2 + 1][col1] + self.sums[row1][col1]


# Your NumMatrix object will be instantiated and called as such:
matrix = [[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7],
          [1, 0, 3, 0, 5]]
obj = NumMatrix(matrix)
print(obj.sumRegion(2, 1, 4, 3))
print(obj.sumRegion(1, 1, 2, 2))
print(obj.sumRegion(1, 2, 2, 4))
