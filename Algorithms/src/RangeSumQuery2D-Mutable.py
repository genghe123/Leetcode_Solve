# https://leetcode.com/problems/range-sum-query-2d-mutable/
# https://www.lintcode.com/problem/range-sum-query-2d-mutable/my-submissions


class NumMatrix(object):

    sums = []
    matrix = []

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        if matrix is None or not matrix:
            return
        row, col = len(matrix), len(matrix[0])
        self.sums = [[0] * (col + 1) for x in range(row + 1)]
        self.matrix = matrix

        acc = 0
        for i in range(row):
            for j in range(col):
                sumAbove = self.sums[i][j + 1]
                acc += matrix[i][j]
                self.sums[i + 1][j + 1] = sumAbove + acc
            acc = 0

    def update(self, row, col, val):
        """
        :type row: int
        :type col: int
        :type val: int
        :rtype: void
        """
        diff = val - self.matrix[row][col]
        for i in range(row, len(self.matrix)):
            for j in range(col, len(self.matrix[0])):
                self.sums[i + 1][j + 1] += diff
        self.matrix[row][col] = val

    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self.sums[row2 + 1][col2 + 1] - self.sums[row1][
            col2 + 1] - self.sums[row2 + 1][col1] + self.sums[row1][col1]


class NumMatrix2:
    matrix = []
    tree = []

   def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        if matrix is None or not matrix:
            return
        self.matrix = [[0 * col] for x in range(row)]
        self.tree = [0 * (col+1) for x in range(row+1)]
        row ,col = len(matrix), len(matrix[0])
        for i in range(row):
            for j in range(col):
                self.update(i,j, matrix[i][j])

    def update(self, row, col, val):
        """
        :type row: int
        :type col: int
        :type val: int
        :rtype: void
        """
        diff = val - self.matrix[i][j]
        self.matrix[i][j] = val

        row += 1
        col += 1

        i ,j = row, col
        while i < :
            while j < col:


    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """

    def lowBit(self, x):
        return x & (-x)


# Your NumMatrix object will be instantiated and called as such:
obj = NumMatrix([[2, 4], [-3, 5]])
obj.update(0, 1, 3)
print(obj.matrix)
print(obj.sums)
obj.update(1, 1, -3)
print(obj.matrix)
print(obj.sums)
obj.update(0, 1, 1)
print(obj.matrix)
print(obj.sums)
print(obj.sumRegion(0, 0, 1, 1))
