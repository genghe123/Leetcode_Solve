package Exercise;

import java.util.Stack;

public class HTMLChecker {
    public static void main(String[] args) {

    }

    public int hasSyntaxError(String input) {
        if (input == null || input.length() == 0) return 1;
        //如果input的首位不是‘<’，或结尾不是‘>’时，可直接判断存在语法错误
        if (input.charAt(0) != '<' || input.charAt(input.length() - 1) != '>') return 0;
        //使用栈存贮打开的标签
        Stack<String> stack = new Stack<>();

        //寻找'<'的坐标
        int p = input.indexOf("<");
        while (p != -1) {
            // 寻找'>'的坐标
            int q = input.indexOf(">", p);
            //如果在后面的字符中未找到'>'，说明该标签未闭合，语法错误
            if (q == -1) return 0;
            //截取从'<'到'>'之间的子字符串
            String s = input.substring(p, q - p + 1);
            // 如果该字符串中有奇数个'"'，说明'<'或'>'有一个在双引号引用范围内，语法错误
            int count = 0;
            for (int a = p; a <= q; a++) {
                if (s.charAt(a) == '\"') count++;
            }
            if (count%2!=0) return 0;
            //如果该标签不是自闭合标签
            if (s.charAt(s.length() - 2) != '/') {
                if (s.charAt(1) == '/') {
                    //该标签是结束标签
                    //如果栈为空，说明仅有结束，没有开始，语法错误
                    if (stack.isEmpty()) return 0;
                    String div1 = stack.pop();
                    String div2 = s.substring(2, s.length() - 2);
                    //比较开始、结束标签是否匹配
                    if (!div1.equalsIgnoreCase(div2)) return 0;
                } else {
                    //该标签是开始标签
                    String tmp = s.split(" ")[0];
                    //将该标签压入stack中
                    stack.push(tmp.substring(1, tmp.length() - 1));
                }
            }
            p = input.indexOf("<");
        }
        //如果最后stack不为空，说明存在标签开始但未结束的情况
        return stack.isEmpty() ? 1 : 0;
    }
}
