// https://leetcode.com/problems/path-sum/description/

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        /*
        // Failed cause when root is null and sum=0, expected result is false while this output true

        if (root == null && sum != 0) return false;
        if (root == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
         */

        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
