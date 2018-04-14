// https://leetcode.com/problems/count-and-say/description/

public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) return "";
        if (n == 1) return "1";
        if (n == 2) return "11";
        StringBuilder stringBuilder = new StringBuilder();
        String say = countAndSay(n - 1);
        int count = 1;
        for (int i = 0; i < say.length() - 1; i++) {
            if (say.charAt(i) == say.charAt(i + 1)) {
                count++;
                continue;
            }
            stringBuilder.append(count);
            stringBuilder.append(say.charAt(i));
            count = 1;
        }
        stringBuilder.append(count);
        stringBuilder.append(say.charAt(say.length() - 1));

        return stringBuilder.toString();
    }
}
