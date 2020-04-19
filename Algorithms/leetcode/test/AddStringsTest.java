import org.junit.Assert;
import org.junit.Test;

public class AddStringsTest {

    private AddStrings add = new AddStrings();

    @Test
    public void addStrings() {
        Assert.assertEquals("666", add.addStrings("222", "444"));
        Assert.assertEquals("6666", add.addStrings("66", "6600"));
        Assert.assertEquals("6666", add.addStrings("6600", "66"));
        Assert.assertEquals("1000", add.addStrings("899", "101"));
    }
}