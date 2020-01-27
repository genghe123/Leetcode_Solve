# https://leetcode.com/problems/sudoku-solver/

class Solution:
    def solveSudoku(self, board):
        self.board = board
        self.solve()
    
    def solve(self):
        row, col = self.findUnassigned()
        if row  == -1 and col == -1:
            return True
        for num in ['1','2','3','4','5','6','7','8','9']:
            if self.isSafe(row,col,num):
                self.board[row][col] = num
                if self.solve():
                    return True
                self.board[row][col] = '.'
        return False

    def findUnassigned(self):
        for row in range(9):
            for col in range(9):
                if self.board[row][col] == '.':
                    return row, col
        return -1, -1

    def isSafe(self, row, col ,ch):
        boxRow = row - row % 3
        boxCol = col - col % 3
        if self.checkRow(row, ch) and self.checkCol(col, ch) and self.checkSquare(boxRow, boxCol, ch):
            return True
        return False
    
    def checkRow(self, row ,ch):
        for col in range(9):
            if self.board[row][col] == ch:
                return False
        return True

    def checkCol(self, col, ch):
        for row in range(9):
            if self.board[row][col] == ch:
                return False
        return True

    def checkSquare(self, row, col , ch):
        for r in range(row, row + 3):
            for c in range(col,col+3):
                if self.board[r][c] == ch:
                    return False
        return True