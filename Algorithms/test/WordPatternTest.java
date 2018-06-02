import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class WordPatternTest {

    private WordPattern pattern = new WordPattern();

    @Test
    public void wordPattern() {
        assertFalse(pattern.wordPattern("abba", "dog cat cat fish"));
        assertFalse(pattern.wordPattern("abba", "dog dog dog dog"));
    }
}