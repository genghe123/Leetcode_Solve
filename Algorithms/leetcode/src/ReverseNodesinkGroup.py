# https://leetcode.com/problems/reverse-nodes-in-k-group/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        return str(self.val) + ', ' + self.next.__str__()

class Solution:
    # TODO
    # FIXME
    # learn about this again
    def reverseKGroup(self, head, k):
        if k <= 0 or head is None:
            return head
    
        dummy = jump = ListNode(None)
        dummy.next = left = right = head

        while True:
            count = 0
            while right and count < k: # use right to locate the range
                right = right.next
                count += 1
            if count == k: # if size k satisfied, reverse the inner linked list
                pre, cur = right, left
                for _ in range(k):
                    tmp = cur.next
                    cur.next = pre
                    pre = cur
                    cur = tmp
                    # cur.next, cur, pre = pre, cur.next, cur # standard reversing
                jump.next = pre
                jump = left
                left = right
                #jump.next, jump, left = pre, left, right # connect two k-groups
            else:
                return dummy.next
    

    # TODO
    # FIXME
    # learn about this again
    def reverseKGroup2(self, head, k):
        curr = head
        count = 0
        while curr is not None and count != k: # find the k+1 node
            curr = curr.next
            count += 1
        if count == k:
            # head - head-pointer to direct part
            # curr - head-pointer to reversed part
            curr = self.reverseKGroup2(curr, k)
            while count > 0:
                tmp = head.next # tmp - next head in direct part
                head.next = curr # preappending "direct" head to the reversed list
                curr = head
                head = tmp
                count -= 1
            head = curr
        return head
            

    def init(self, array):
        head = ListNode(0)
        p = head
        for i in array:
            p.next = ListNode(i)
            p = p.next
        return head.next

sol = Solution()
head = sol.init([258,419,140,384,271,232,388,324,394,131,355,113,79,402,304,437,196,230,289,356,493,268,425,305,384,326,332,44,341,230,375,99,1,367,335,124,100,224,448,494,207,156,108,286,58,264,76,106,347,217,462,340,486,240,145,370,418,330,266,111,412,494,63,413,361,398,38,313,474,338,160,181,494,120,320,404,384,248,10,231,465,325,423,303,65,421,26,335,251,144,446,163,138,9,428,352,260,466,17,86,157,177,268,151,149,440,408,386,40,270,469,357,95,393,161,12,314,39,347,417,183,294,80,322,303,8,26,63,327,43,150,484,73,270,487,222,62,247,460,454,18,430,163,113,323,176,126,489,215,473,406,399,119,486,73,275,346,451,190,25,346,192,9,419,314,349,494,228,96,454,182,114,384,198,80,59,374,206,48,442,31,454,341,3,292,266,278,139,217,468,16,415,13,378,335,327,227,181,56,175,487,90,290,372,288,222,431,15,428,332,457,311,286,150,314,79,416,92,70,485,413,438,400,278,316,87,105,395,120,13,71,108,456,213,480,96,435,263,111,215,447,68,26,234,218,341,165,486,285,87,323,50,25,76,328,194,15,286,89,136,299,160,244,107,225,76,204,160,191,315,375,139,236,402,225,306,95,390,145,380,329,468,283,206,396,111,400,412,397,490,400,49,2,144,156,228,72,360,388,263,28,116,254,264,370,479,70,465,221,215,197,50,36,480,109,432,92,9,196,341,351,96,390,354,92,47,82,16,407,322,280,435,438,386,51,160,366,474,125,439,41,175,342,77,155,451,362,99,460,410,293,312,359,183,18,451,82,452,468,342,274,100,129,65,486,181,225,204,155,203,144,48,378,486,126,385,289,340,337,249,102,130,413,461,165,283,413,248,235,233,90,10,185,219,427,23,252,152,228,259,355,224,308,85,62,286,471,351,478,308,452,80,290,218,42,455,1,307,203,237,392,145,99,77,217,26,100,321,30,180,81,386,256,241,471,318,27,294,21,357,102,326,289,392,44,183,200,45,490,403,134,234,401,233,163,470,259,116,291,290,296,372,28,405,465,351,75,344,146,97,201,100,423,491,345,319,174,45,364,17,300,351,103,201,84,267,171,196,383,315,338,31,187,366,436,153,69,12,497,215,461,51,316,236,42,13,55,68,58,271,437,358,122,41,412,59,308,435,255,43,250,93,74,290,311,363,295,232,227,292,448,188,195,116,276,89,129,183,158,39,306,95,397,281,488,161,340,296,97,447,339,347,392,266,137,203,129,432,287,356,77,235,396,124,203,172,214,184,207,224,223,13,171,473,294,160,134,486,308,83,433,0,431,325,266,420,380,247,205,168,455,282,255,351,258,311,375,472,495,434,196,71,447,220,396,94,380,382,80,40,466,14,40,249,191,158,21,72,257,226,92,212,360,347,415,119,158,142,443,6,76,140,429,376,360,177,470,92,59,402,132,377,268,25,478,460,183,0,384,441,78,476,5,439,175,421,410,186,63,353,192,492,493,473,368,205,150,190,149,209,92,134,439,213,159,417,173,194,269,409,135,348,237,141,287,412,414,197,98,477,402,142,321,248,115,189,305,265,231,455,327,324,441,266,37,100,35,62,294,305,323,282,153,60,423,292,324,337,341,423,166,243,417,340,491,33,29,297,150,261,104,329,437,45,95,326,497,483,240,291,140,63,73,293,475,348,437,299,37,278,222,56,373,492,396,217,25,277,366,27,390,322,357,179,367,304,5,364,287,97,7,427,160,433,72,135,281,9,287,171,139,361,227,365,353,123,434,378,252,300,258,143,122,115,322,341,419,180,205,59,277,64,486,438,497,411,425,279,272,212,450,264,74,29,129,427,152,63,158,404,215,416,399,337,383,222,178,302,402,235,361,179,299,200,469,297,111,247,428,235,311,378,499,385,407,128,165,411,43,175,167,258,443,67,447,326,141,125,480,43,212,342,74,12,394,396,161,5,143,89,92,454,319,92,192,226,72,209,489,116,236,8,226,179,75,26,357,68,151,337,463,216,31,38,228,425,286,389,282,429,478,375,235,297,467,279,375,391,340,216,359,76,224,86,107,152,112,464,220,115,154,184,183,185,74,411,111,360,152,393,141,482,268,228,131,87,8,358,479,348,74,190,277,151,276,384,303,240,201,375,208,355,411,391,40,337,155,151,49,307,397,190,142,17,271,273,105,279,132,436,479,206,126,256,209,255,493,364,347,194,240,407,49,3,299,441,341,306,93,390,465,490,433,107,359,204,381,464,335,365,252,314,423,231,423,133,486,268,497,185,462,89,93,363,93,244,156,434,50,249,176,15,91,109,475,451,313,208,267,148,73,372,315,496,103,90,481,441,358,479,126,172,68,71,387,13,315,43,299,365,293,476,233,236,85,208,39,251,416,159,251,341,383,66,337,486,156,171,279,14,150,257,38,70,329,425,436,144,469,235,362,114,211,95,202,149,155,242,252,71,253,3,264,136,422,453,474,78,124,253,445,126,10,483,197,339,409,485,336,230,220,198,344,284,293,46,433,300,140,37,223,393,40,487,381,462,440,355,393,65,460,190,191,323,25,240,14,286,225,350,16,446,400,360,82,193,259,367,493,399,404,216,145,296,55,26,111,496,234,4,61,194,46,104,369,71,345,384,358,422,86,226,368,487,87,302,32,198,169,378,97,73,446,242,370,2,269,481,498,3,337,411,49,235,15,271,306,360,155,16,283,93,95,3,80,34,158,465,232,327,343,329,253,289,72,475,143,193,308,141,48,145,404,97,232,420,368,390,132,375,407,267,469,354,123,401,388,281,366,120,108,61,449,213,203,373,188,346,66,496,340,466,493,244,416,225,164,284,116,297,12,375,416,333,229,39,86,117,320,305,89,281,366,390,494,69,264,183,268,182,31,108,149,25,352,65,102,17,201,218,166,65,445,82,250,174,122,337,143,294,142,84,427,360,475,422,430,91,457,198,125,340,306,274,365,158,191,320,27,245,38,193,162,484,128,413,10,102,250,6,248,244,90,176,104,417,450,386,8,259,84,134,99,242,260,317,253,304,137,132,401,27,178,63,363,306,328,226,260,78,232,8,174,174,184,279,444,486,165,452,245,102,438,197,196,51,14,449,207,3,434,108,30,112,23,246,270,352,472,30,430,56,38,457,230,75,236,26,61,253,331,307,355,269,4,404,172,370,353,379,225,139,339,107,251,363,353,21,215,325,51,497,233,442,454,316,17,42,342,78,296,173,237,3,295,93,407,467,315,113,199,40,252,38,148,4,401,353,377,116,31,281,466,264,223,420,80,92,463,423,22,259,96,260,114,243,205,22,63,21,135,262,61,239,152,61,95,54,415])
res=sol.reverseKGroup2(head,711)
while res is not None:
    print(res.val,end=', ')
    res = res.next