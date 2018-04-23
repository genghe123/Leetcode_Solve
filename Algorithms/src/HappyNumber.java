// https://leetcode.com/problems/happy-number/description/

// https://leetcode.com/problems/happy-number/discuss/56918/All-you-need-to-know-about-testing-happy-number!
// https://leetcode.com/problems/happy-number/discuss/56919/Explanation-of-why-those-posted-algorithms-are-mathematically-valid

public class HappyNumber {
    public boolean isHappy(int n) {
        int x = n, y = n;
        while (true) {
            x = cal(x);
            if (x == 1) return true;
            y = cal(cal(y));
            if (y == 1) return true;
            if (x == y) return false;
        }
    }

    private int cal(int n) {
        int ans = 0;
        while (n > 0) {
            ans += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        return ans;
    }
}
