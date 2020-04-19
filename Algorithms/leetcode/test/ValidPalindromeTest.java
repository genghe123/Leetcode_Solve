import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPalindromeTest {

    private ValidPalindrome validPalindrome = new ValidPalindrome();

    @Test
    public void isPalindrome() {
        assertTrue(validPalindrome.isPalindrome("A Solution, a plan, a canal: Panama"));
        assertTrue(validPalindrome.isPalindrome(""));
        assertTrue(validPalindrome.isPalindrome(",."));
        assertTrue(validPalindrome.isPalindrome(",.~"));
        assertFalse(validPalindrome.isPalindrome("race a car"));
        assertFalse(validPalindrome.isPalindrome("0P"));
    }
}