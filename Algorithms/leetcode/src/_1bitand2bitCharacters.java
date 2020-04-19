// https://leetcode.com/problems/1-bit-and-2-bit-characters/solution/

public class _1bitand2bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

}
