// https://leetcode.com/problems/rotate-array/description/

public class RotateArray {

    /*
    // Using Cyclic Replacements
    // We can directly place every number of the array at its required correct position. But if we do that, we will
    // destroy the original element. Thus, we need to store the number being replaced in a temptemp variable. Then, we
    // can place the replaced number(temptemp) at its correct position and so on, nn times, where nn is the length of
    // array. We have chosen nn to be the number of replacements since we have to shift all the elements of the array(which is nn).
    // But, there could be a problem with this method, if n where k=k(since a value of kk larger than nn eventually
    // leads to a kk equivalent to k). In this case, while picking up numbers to be placed at the correct position,
    // we will eventually reach the number from which we originally started. Thus, in such a case, when we hit the
    // original number's index again, we start the same process with the number following it.

    // Time complexity : O(n)
    // Space complexity : O(1)

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
     */

    // Using Reverse
    // This approach is based on the fact that when we rotate the array k times, k elements from the back end of the
    // array come to the front and the rest of the elements from the front shift backwards.
    // In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed
    // by reversing the rest n-kn−k elements gives us the required result.
    // Let n=7 and k=3
    // Original List                   : 1 2 3 4 5 6 7
    // After reversing all numbers     : 7 6 5 4 3 2 1
    // After reversing first k numbers : 5 6 7 4 3 2 1
    // After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
