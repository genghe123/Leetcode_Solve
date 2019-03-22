// https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length <= 2) return Math.min(cost[0], cost[1]);

        int n = cost.length;
        int[] rns = new int[n];

        for (int i = 2; i < n; i++) {
            rns[i] = Integer.MAX_VALUE;
        }

        rns[0] = cost[0];
        rns[1] = cost[1];

        for (int i = 2; i < n; i++) {
            rns[i] = Math.min(rns[i - 1], rns[i - 2]) + cost[i];
        }

        return Math.min(rns[n - 1], rns[n - 2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length <= 2) return Math.min(cost[0], cost[1]);
        int a = cost[1];
        int b = cost[0];
        for (int i = 2; i < cost.length; i++) {
            int t = cost[i] + Math.min(a, b);
            b = a;
            a = t;
        }
        return Math.min(a, b);
    }
}
