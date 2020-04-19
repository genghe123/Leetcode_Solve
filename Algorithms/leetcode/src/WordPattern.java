// https://leetcode.com/problems/word-pattern/description/

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || "".equals(pattern) || "".equals(str)) return false;
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!map.containsValue(strs[i]))
                    map.put(pattern.charAt(i), strs[i]);
                else return false;
            } else if (!map.get(pattern.charAt(i)).equalsIgnoreCase(strs[i])) {
                return false;
            }
        }
        return true;
    }
}
