package LeetCode;

/*  112. Path Sum
 *   https://leetcode-cn.com/problems/path-sum/
 * */

public class PathSum112 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return find(root, targetSum, 0);
    }

    public boolean find(TreeNode root, int targetSum, int sum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                return true;
            } else return false;
        }
        boolean flag = false;
        if (root.left != null) {
            flag = flag || find(root.left, targetSum, sum);
        }
        if (root.right != null && !flag) {
            flag = flag || find(root.right, targetSum, sum);
        }
        return flag;
    }
}
