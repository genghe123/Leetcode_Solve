import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBinaryTest {

    private AddBinary addBinary = new AddBinary();

    @Test
    public void addBinary() {
        assertEquals("11", addBinary.addBinary("1", "10"));
        assertEquals("11110", addBinary.addBinary("1111", "1111"));

    }
}