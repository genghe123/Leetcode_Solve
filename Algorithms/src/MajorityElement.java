// https://leetcode.com/problems/majority-element/description/

import java.util.Random;

public class MajorityElement {

    /*

    // HashMap
    // Time complexity : O(n)
    // Space complexity : O(n)

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) counts.put(num, 1);
            else counts.put(num, counts.get(num) + 1);
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue())
                majorityEntry = entry;
        }
        return majorityEntry.getKey();
    }
     */


    /*

    // Sorting
    // Time complexity : O(nlgn)
    // Space complexity : O(1) or O(n)

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
     */

    // Randomization Accepted?
    // Because more than ⌊n/2⌋ array indices are occupied by the majority element, a random array index is likely to contain the majority element.
    // we can just select a random index, check whether its value is the majority element, return if it is, and repeat if it is not.
    // The algorithm is verifiably correct because we ensure that the randomly chosen value is the majority element before ever returning.
    // Time complexity : O(∞)

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num)
                count++;
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount)
                return candidate;
        }
    }
}
