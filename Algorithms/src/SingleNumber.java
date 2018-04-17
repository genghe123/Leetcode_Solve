// https://leetcode.com/problems/single-number/description/

import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        //HashTable
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer num : nums) {
            if (hashSet.contains(num)) hashSet.remove(num);
            else hashSet.add(num);
        }
        Integer[] array = new Integer[1];
        hashSet.toArray(array);
        return array[0];
    }
}
