// https://leetcode.com/problems/pascals-triangle/description/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//todo
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> list = pascalsTriangle.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {

        /*
        Time complexity: O(numRows^2)
         */
        List<List<Integer>> listList = new LinkedList<>();
        if (numRows <= 0) return listList;
        listList.add(Arrays.asList(1));
        if (numRows >= 2) listList.add(Arrays.asList(1, 1));

        List<Integer> list = listList.get(listList.size() - 1);

        for (int num = 3; num <= numRows; num++) {
            List<Integer> preList = list;
            list = new LinkedList<>();
            list.add(1);
            for (int i = 0; i < preList.size() - 1; i++) {
                list.add(preList.get(i) + preList.get(i + 1));
            }
            list.add(1);
            listList.add(list);
        }
        return listList;
    }
}
