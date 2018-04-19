// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1 || target < numbers[0] + numbers[1]) return new int[2];

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) j--;
            else if (numbers[i] + numbers[j] < target) i++;
            else return new int[]{i + 1, j + 1};
        }
        return new int[2];
    }
}
