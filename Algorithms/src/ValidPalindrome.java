// https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        s = s.trim().toUpperCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            /*
            // For Debug use
            char a = s.charAt(i);
            char b = s.charAt(j);
             */
            if (i > j) return true;
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
