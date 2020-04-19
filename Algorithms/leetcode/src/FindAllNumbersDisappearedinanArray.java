// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length + 1;
        int[] rns = new int[n];

        for (int num : nums) {
            rns[num]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (rns[i] == 0)
                list.add(i);
        }
        return list;
    }
}
