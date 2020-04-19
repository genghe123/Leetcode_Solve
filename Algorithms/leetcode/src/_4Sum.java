// https://leetcode.com/problems/4sum/description/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new LinkedList<>();
        int len = nums.length;
        if (len < 4) return listList;

        Arrays.sort(nums);
        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target) return listList;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1]) continue; // avoid duplicate
            if (z + 3 * max < target) continue; // z is too small
            if (4 * z > target) continue; // z is too large
            if (4 * z == target) { // zi is the boundary
                if (i + 3 < len && nums[i + 3] == z) {
                    listList.add(Arrays.asList(z, z, z, z));
                    break;
                }
            }
            threeSumForFourSum(nums, target - z, i + 1, len - 1, listList, z);
        }
        return listList;
    }

    public void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> list, int first) {
        if (low + 1 >= high) return;
        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target) return;
        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) continue;
            if (z + 2 * max < target) continue;
            if (3 * z > target) break;
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z)
                    list.add(Arrays.asList(first, z, z, z));
                break;
            }
            twoSumForFourSum(nums, target - z, i + 1, high, list, first, z);
        }
    }

    private void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> list, int first, int second) {
        if (low >= high) return;
        if (2 * nums[low] > target || 2 * nums[high] < target) return;
        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                list.add(Arrays.asList(first, second, nums[i], nums[j]));
                x = nums[i];
                while (++i < j && x == nums[i]) ;
                x = nums[j];
                while (i < --j && x == nums[j]) ;
            } else if (sum < target) i++;
            else j--;
        }
        return;
    }
}