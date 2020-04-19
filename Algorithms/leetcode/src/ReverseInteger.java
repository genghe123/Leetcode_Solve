public class ReverseInteger {
    public int reverse(int x) {
        char[] digits = String.valueOf(x).toCharArray();
        int num = 0;
        int max = Integer.MAX_VALUE / 10;
        for (int i = digits.length - 1; i > 0; i--) {
            if (num <= max) {
                num *= 10;
                num += digits[i] - '0';
            } else {
                return 0;
            }
        }
        if (digits[0] == '-') {
            num = -num;
        } else {
            if (num <= max) {
                num *= 10;
                num += digits[0] - '0';
            } else {
                return 0;
            }
        }
        return num;
    }

}
