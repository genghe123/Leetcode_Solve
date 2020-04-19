import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsomorphicStringsTest {

    private IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

    @Test
    public void isIsomorphic() {
        assertTrue(isomorphicStrings.isIsomorphic("egg", "add"));
        assertTrue(isomorphicStrings.isIsomorphic("paper", "title"));
        assertFalse(isomorphicStrings.isIsomorphic("foo", "bar"));
        assertFalse(isomorphicStrings.isIsomorphic("ab", "aa"));
    }
}