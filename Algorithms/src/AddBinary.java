// https://leetcode.com/problems/add-binary/description/

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0, sum = 0;
        while (i > -1 || j > -1) {
            sum = ((i > -1) ? Character.getNumericValue(a.charAt(i--)) : 0) +
                    ((j > -1) ? Character.getNumericValue(b.charAt(j--)) : 0) + carry;
            carry = sum / 2;
            stringBuilder.append(sum % 2);
        }
        if (carry != 0) stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }
}
