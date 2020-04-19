import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    public void longestCommonPrefix() {
        //assertEquals("", new String[]{""});
        assertEquals("a", longestCommonPrefix.longestCommonPrefix(new String[]{"a"}));
        assertEquals("ab", longestCommonPrefix.longestCommonPrefix(new String[]{"ab"}));
        assertEquals("abc", longestCommonPrefix.longestCommonPrefix(new String[]{"abc"}));
        assertEquals("lee", longestCommonPrefix.longestCommonPrefix(new String[]{"leets", "leetcode", "leet", "leed"}));
        assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[]{"aca", "cba"}));
        assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[]{"abcd", "dbcd"}));

    }
}