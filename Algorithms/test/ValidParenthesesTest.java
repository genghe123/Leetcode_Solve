import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {

    private ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void isValid() {
        assertTrue(validParentheses.isValid("()[]{}"));
        assertTrue(validParentheses.isValid("([{}])"));
        assertTrue(validParentheses.isValid("([]{})"));
        assertTrue(validParentheses.isValid("[({})[]]"));
        assertFalse(validParentheses.isValid("({)}"));
        assertFalse(validParentheses.isValid(""));
        assertFalse(validParentheses.isValid("(9)"));
        assertFalse(validParentheses.isValid("){"));
        assertFalse(validParentheses.isValid("(("));

    }
}