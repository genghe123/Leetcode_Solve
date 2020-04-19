# https://leetcode.com/problems/valid-sudoku/

import collections

class Solution:
    def isValidSudoku(self, board):
        count = list(collections.Counter(
            x
            for i , row in enumerate(board)
            for j , c in enumerate(row)
            if c != '.'
            for x in ((c,i), (j,c), (i/3,j/3,c))
        ).values())+[1]

        return 1 == max(count)