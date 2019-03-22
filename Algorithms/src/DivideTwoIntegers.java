public class DivideTwoIntegers {


    public int divide(int dividend, int divisor) {
        if (divisor == 0) return -1;
        if (dividend == 0) return 0;
        if (dividend == -(1 << 31) && divisor == -1) return (1 << 31) - 1;

        boolean sign = (dividend > 0) ^ (divisor > 0);
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);

        int result = 0;
        while (x >= y) {
            int shift = 1;
            while (x >= (y << shift)) {
                shift++;
            }
            x -= y << (shift - 1);
            result += 1 << (shift - 1);
        }

        return sign ? -result : result;
    }
}
