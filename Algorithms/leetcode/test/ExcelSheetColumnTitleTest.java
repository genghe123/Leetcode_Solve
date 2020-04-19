import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelSheetColumnTitleTest {

    private ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

    @Test
    public void convertToTitle() {
        assertEquals("A", excelSheetColumnTitle.convertToTitle(1));
        assertEquals("B", excelSheetColumnTitle.convertToTitle(2));
        assertEquals("Z", excelSheetColumnTitle.convertToTitle(26));
        assertEquals("AA", excelSheetColumnTitle.convertToTitle(27));
        assertEquals("AZ", excelSheetColumnTitle.convertToTitle(52));
    }
}