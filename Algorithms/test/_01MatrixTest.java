import org.junit.Assert;
import org.junit.Test;

public class _01MatrixTest {

    private _01Matrix matrix = new _01Matrix();

    @Test
    public void updateMatrix() {
        Assert.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, matrix.updateMatrix2(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        Assert.assertArrayEquals(
                new int[][]{
                        {2, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                        {1, 0, 0, 1, 0, 1, 1, 2, 2, 1},
                        {1, 1, 1, 0, 0, 1, 2, 2, 1, 0},
                        {0, 1, 2, 1, 0, 1, 2, 3, 2, 1},
                        {0, 0, 1, 2, 1, 2, 1, 2, 1, 0},
                        {1, 1, 2, 3, 2, 1, 0, 1, 1, 1},
                        {0, 1, 2, 3, 2, 1, 1, 0, 0, 1},
                        {1, 2, 1, 2, 1, 0, 0, 1, 1, 2},
                        {0, 1, 0, 1, 1, 0, 1, 2, 2, 3},
                        {1, 2, 1, 0, 1, 0, 1, 2, 3, 4}
                },
                matrix.updateMatrix2(
                        new int[][]{
                                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
                        }
                ));
    }
}
