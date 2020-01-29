# https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china


class Solution:

    primes = set([2, 3, 5, 7, 11, 13, 17, 19, 23, 31])

    def countPrimeSetBits(self, L, R):
        if L > R: return 0
        count = 0
        for n in range(L, R + 1):
            sumv = 0
            # https://blog.csdn.net/wcnmcsdn/article/details/78734552
            while n:
                sumv += 1
                n &= n - 1
            if sumv in self.primes:
                count += 1
        return count

    def countPrimeSetBits2(self, L, R):
        return sum(
            [1 for v in range(L, R + 1) if bin(v).count('1') in self.primes])
