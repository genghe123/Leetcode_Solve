// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length + 1;
        int[] rns = new int[n];

        for (int num : nums) {
            rns[num]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (rns[i] >= 2)
                list.add(i);
        }
        return list;
    }
}
