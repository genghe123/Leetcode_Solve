// https://leetcode.com/problems/excel-sheet-column-title/description/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        while (n >= 1) {
            stringBuilder.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }

        return stringBuilder.reverse().toString();
    }
}