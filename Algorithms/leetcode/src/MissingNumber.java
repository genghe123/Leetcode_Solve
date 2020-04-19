// https://leetcode.com/problems/missing-number/description/

public class MissingNumber {

    //Sorting
    //Hashset

    //Bit Manipulation
    public int missingNumber1(int[] nums) {
        /*
        XOR is its own inverse to find the missing element in linear time.

        nums contains nn numbers and that it is missing exactly one number on the range
        [0..n-1][0..n−1], we know that nn definitely replaces the missing number in nums.
        Therefore, if we initialize an integer to nn and XOR it with every index and value,
        we will be left with the missing number.
         */
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    //Gauss's Formula
    public int missingNumber2(int[] nums) {
        /*
        We can compute the sum of nums in linear time, and by Gauss' formula,
         we can compute the sum of the first nn natural numbers in constant time.
         Therefore, the number that is missing is simply the result of Gauss' formula
         minus the sum of nums, as nums consists of the first nn natural numbers minus
         some number.
         */
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
