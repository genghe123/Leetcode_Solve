// https://leetcode.com/problems/isomorphic-strings/description/

public class IsomorphicStrings {

    /*

    // Using HashMap

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (!map.containsValue(t.charAt(i)))
                    map.put(s.charAt(i), t.charAt(i));
                else return false;
            } else if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
     */

    /*
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256]) return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
     */

    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) return true;
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
