// https://leetcode.com/problems/reverse-bits/description/

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {
    // Optimization 1: Divide an int into 4 bytes and use cache
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();


    /*
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 31; i++) {
            result += n & 1;
            n >>>= 1; // CATCH: must do unsigned shift
            result <<= 1;
        }
        result += n & 1;
        return result;
    }
     */

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        int n = 43261596;
        System.out.printf("Before: %d   %32s\n", n, Integer.toBinaryString(n));
        n = reverseBits.reverseBits(n);
        System.out.printf("After: %d   %32s\n", n, Integer.toBinaryString(n));
    }

    public int reverseBits(int n) {
        int ret = n;
        ret = ret >>> 16 | ret << 16;
        ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
        ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
        ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
        ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
        return ret;
    }
}
