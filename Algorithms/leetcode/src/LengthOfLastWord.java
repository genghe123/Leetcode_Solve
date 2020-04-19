// https://leetcode.com/problems/length-of-last-word/description/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        /*
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
         */
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') count++;
            else break;
        }
        return count;
    }
}
