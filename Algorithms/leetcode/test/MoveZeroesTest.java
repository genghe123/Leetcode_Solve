import org.junit.Assert;
import org.junit.Test;

public class MoveZeroesTest {

    private MoveZeroes moveZeroes = new MoveZeroes();

    @Test
    public void moveZeroes() {
        int[] array = new int[]{0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(array);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, array);
        array = new int[]{0};
        moveZeroes.moveZeroes(array);
        Assert.assertArrayEquals(new int[]{0}, array);
    }
}