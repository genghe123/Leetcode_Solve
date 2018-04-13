//https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.equals("")) return false;
        char[] chars = s.trim().toCharArray();
        if (chars.length % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != c - 1)
                        return false;
                    break;
                case ']':
                case '}':
                    if (stack.empty() || stack.pop() != c - 2)
                        return false;
                    break;
                default:
                    return false;
            }
        }
        return stack.empty();

    }
}
