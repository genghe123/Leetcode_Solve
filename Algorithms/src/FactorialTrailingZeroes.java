// https://leetcode.com/problems/factorial-trailing-zeroes/description/

public class FactorialTrailingZeroes {

    // all trailing 0 is from factors 5 * 2.
    //
    //But sometimes one number may have several 5 factors,
    // for example, 25 have two 5 factors, 125 have three 5 factors.
    // In the n! operation, factors 2 is always ample. So we just
    // count how many 5 factors in all number from 1 to n.

    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}
