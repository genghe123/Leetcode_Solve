# https://leetcode.com/problems/find-median-from-data-stream/

from queue import PriorityQueue

# Two Heaps (low half max heap, high half min heap)
class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.lo = PriorityQueue() # max heap
        self.hi = PriorityQueue() # min heap

    def addNum(self, num):
        self.lo.put(-num) # Add to max heap
        self.hi.put(-self.lo.get()) # Balancing step
        if self.lo.qsize() < self.hi.qsize():
            self.lo.put(-self.hi.get())

    def findMedian(self):
        return -self.lo.queue[0] if self.lo.qsize() > self.hi.qsize() else (-self.lo.queue[0] + self.hi.queue[0]) / 2

# Your MedianFinder object will be instantiated and called as such:
obj = MedianFinder()
obj.addNum(41)
print(obj.findMedian())
obj.addNum(35)
print(obj.findMedian())
obj.addNum(62)
print(obj.findMedian())
obj.addNum(4)
print(obj.findMedian())
obj.addNum(97)
print(obj.findMedian())
obj.addNum(108)
print(obj.findMedian())