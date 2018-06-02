// https://leetcode.com/problems/add-strings/description/

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || (num1.length() == 1 && "0".equals(num1.charAt(0)))) return num2;
        if (num2 == null || (num2.length() == 1 && "0".equals(num2.charAt(0)))) return num1;

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int sum = 0;
        int max = Math.max(i, j) + 2;
        char[] result = new char[max];
        while (i >= 0 || j >= 0) {
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            max = Math.max(i, j) + 1;
            result[max + 1] = (char) (sum % 10 + 48);
            sum /= 10;
        }
        result[0] = (char) (sum % 10 + 48);
        if (result[0] == '0') return new String(result, 1, result.length - 1);
        else return new String(result);
    }
}
