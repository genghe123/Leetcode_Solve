//  https://leetcode.com/problems/excel-sheet-column-number/description/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int reuslt = 0;
        for (char c : s.trim().toCharArray()) {
            reuslt = reuslt * 26 + c - 'A' + 1;
        }
        return reuslt;
    }
}
