// https://leetcode.com/problems/longest-common-prefix/description/"
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.longestCommonPrefix(new String[]{""});
    }

    public String longestCommonPrefix(String[] strs) {
        /*
        if (strs == null || strs.length == 0) return "";

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        if (minLength == 0) return "";

        int low = 0, high = minLength, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (high + low) / 2);
         */

        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String subStringOfFirstElement = strs[0].substring(0, len);
        for (String str : strs) {
            if (!str.startsWith(subStringOfFirstElement)) {
                return false;
            }
        }
        return true;
    }


}
