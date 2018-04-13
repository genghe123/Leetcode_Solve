import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPositionTest {

    private SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @Test
    public void searchInsert() {
        Assert.assertEquals(2, searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(0, searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 0));
        Assert.assertEquals(1, searchInsertPosition.searchInsert(new int[]{1, 3}, 2));

    }
}