// https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking

/**
 * f(n) = f(n-1) + f(n-2) + ... + f(1)
 * f(n-1) = f(n-2) + f(n-3) + ... + f(1)
 * => f(n) - f(n-1) = f(n-1)
 * => f(n) = 2f(n-1)
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        return 1 << (target - 1);
    }
}