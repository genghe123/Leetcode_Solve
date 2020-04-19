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

# Binary Indexed Tree(B.I.T)
class NumMatrix2(object):
    matrix = []
    tree = []

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        if matrix is None or not matrix:
            return
        row, col = len(matrix), len(matrix[0])
        self.matrix = [[0] * col for x in range(row)]
        self.tree = [[0] * (col + 1) for x in range(row + 1)]
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
        diff = val - self.matrix[row][col]
        self.matrix[row][col] = val

        i ,j = row+1, col+1
        while i <= len(self.matrix):
            j = col + 1
            while j <= len(self.matrix[0]):
                self.tree[i][j] += diff
                j += self.lowBit(j)
            i += self.lowBit(i)


    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self.getSum(row2,col2) - self.getSum(row1-1, col2) - self.getSum(row2,col1-1) + self.getSum(row1-1,col1-1)

    def lowBit(self, x):
        return x & (-x)

    def getSum(self, row, col):
        res = 0
        i,j = row+1,col+1
        while i>=1:
            j = col + 1
            while j>=1:
                res += self.tree[i][j]
                j -= self.lowBit(j)
            i -= self.lowBit(i)
        return res

# todo
# FIXME
# class NumMatrix3(object):
    

# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix2([[2, 4], [-3, 5]])
# # obj.update(0, 1, 3)
# print(obj.matrix)
# obj.update(1, 1, -3)
# print(obj.matrix)
# obj.update(0, 1, 1)
# print(obj.matrix)
# print(obj.sumRegion(0, 0, 1, 1))

obj=NumMatrix2([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]])
print(obj.sumRegion(2, 1, 4, 3))
obj.update(3, 2, 2)
print(obj.sumRegion(2, 1, 4, 3))