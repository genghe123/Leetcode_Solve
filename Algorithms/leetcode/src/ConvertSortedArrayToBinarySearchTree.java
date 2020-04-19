// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, low, mid - 1);
        node.right = construct(nums, mid + 1, high);
        return node;
    }
}
