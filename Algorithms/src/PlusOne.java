// https://leetcode.com/problems/plus-one/description/

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{ };
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i - 1]++;
                digits[i] -= 10;
            }
        }
        if (digits[0] >= 10) {
            int[] newdigits = new int[digits.length + 1];
            newdigits[0] = 1;
            newdigits[1] = digits[0] - 10;
            for (int i = 1; i < digits.length; i++) {
                newdigits[i + 1] = digits[i];
            }
            return newdigits;
        }
        return digits;
    }
}
