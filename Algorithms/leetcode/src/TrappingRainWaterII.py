# https://leetcode.com/problems/trapping-rain-water-ii/

import queue

class Solution:

    class Cell:
        x, y, h = 0, 0, 0

        def __init__(self, x, y, h):
            self.x = x
            self.y = y
            self.h = h

    def trapRainWater(self, heightMap):
        if self.isInvalid(heightMap):
            return 0
        
        m, n = len(heightMap), len(heightMap[0])
        dx = [0,0,1,-1]
        dy = [1,-1,0,0]
        visted = [[False] * n for xd]

        q = queue.PriorityQueue()

        

    def init(self, visted, q, heightMap):
        m, n = len(heightMap), len(heightMap[0])
        for i in range(0,m):
            visted[i][0] = True
            visted[i][n-1] = True
            q.offer(self.Cell(i, 0, heightMap[i][0]))
            q.offer(self.Cell(i,n-1,heightMap[i][n-1]))
        for j in range(0,n):
            visted[0][j] = True
            visted[m-1][j] = True
            q.offer(self.Cell(0,j,heightMap[0]))
            q.offer(self.Cell(m-1,j,heightMap[m-1][j]))


    def isValidCoordinate(self, x, y, visted):
        row = len(visted)
        col = len(visted[0])
        return x >= 0 and x < row and y >= 0 and y < col and not visted[x][y]

    def isInvalid(self, heightMap):
        return heightMap is None or len(heightMap) == 0 or len(heightMap[0]) == 0
        
    
    
