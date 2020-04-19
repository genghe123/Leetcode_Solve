// https://leetcode.com/problems/single-number/description/

public class SingleNumber {
    public int singleNumber(int[] nums) {

        /*
        // HashTable
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer num : nums) {
            if (hashSet.contains(num)) hashSet.remove(num);
            else hashSet.add(num);
        }
        Integer[] array = new Integer[1];
        hashSet.toArray(array);
        return array[0];
         */

        //Bit Manipulation
        /*
        If we take XOR of zero and some bit, it will return that bit
        a⊕0=a
        If we take XOR of two same bits, it will return 0
        a⊕a=0
        a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
        So we can XOR all bits together to find the unique number.
         */
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
