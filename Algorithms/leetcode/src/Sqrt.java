// https://leetcode.com/problems/sqrtx/description/

public class Sqrt {
    public int mySqrt(int x) {
        /*
        // Newton's iterative method
        double result = x;
        double delta = 0.0001;
        while (Math.abs(result * result - x) > delta) {
            result = result - (result * result - x) / 2 / result;
        }
        return (int) result;
         */

        int low = 1;
        int high = x;
        int result = 0;
        if (x == 0) return 0;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
