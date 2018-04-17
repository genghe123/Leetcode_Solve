import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    private ValidPalindrome validPalindrome = new ValidPalindrome();

    @Test
    public void isPalindrome() {
        assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(validPalindrome.isPalindrome(""));
        assertTrue(validPalindrome.isPalindrome(",."));
        assertTrue(validPalindrome.isPalindrome(",.~"));
        assertFalse(validPalindrome.isPalindrome("race a car"));
        assertFalse(validPalindrome.isPalindrome("0P"));
    }
}