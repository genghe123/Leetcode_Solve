// https://leetcode.com/problems/pascals-triangle-ii/description/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        pascalsTriangleII.getRow(5);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        if (rowIndex < 0) return list;
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
