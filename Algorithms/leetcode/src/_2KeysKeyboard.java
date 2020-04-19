// https://leetcode.com/problems/2-keys-keyboard/description/

// https://leetcode.com/problems/2-keys-keyboard/solution/
// todo understand the algorithm
public class _2KeysKeyboard {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n = n / i;
            }
        }
        return res;
    }
}
