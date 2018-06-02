import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class _2KeysKeyboardTest {
    private int expected;
    private int num;
    private _2KeysKeyboard keyboard = new _2KeysKeyboard();

    public _2KeysKeyboardTest(int num, int expected) {
        this.num = num;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{{1, 0}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 5},
                {7, 7}, {8, 6}, {9, 6}, {10, 7}, {11, 11}, {12, 7}, {13, 13}, {14, 9}, {15, 8},
                {24, 9}, {100, 14}});
    }

    @Test
    public void minSteps() {
        assertEquals(expected, keyboard.minSteps(num));
    }
}