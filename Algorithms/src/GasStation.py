# https://leetcode.com/problems/gas-station/
# https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.


class Solution:
    def canCompleteCircuit(self, gas, cost):
        if sum(gas) < sum(cost):
            return -1
        length = len(gas)
        net = []
        for i in range(length):
            net.append(gas[i] - cost[i])
        acc, pos = 0, 0
        for i in range(length):
            acc += net[i]
            if acc < 0:
                acc = 0
                pos = i + 1
        return pos


if __name__ == "__main__":
    sol = Solution()
    pos = sol.canCompleteCircuit([1, 2, 3, 4, 5], [3, 4, 5, 1, 2])
    print(pos)
