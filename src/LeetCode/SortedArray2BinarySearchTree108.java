package LeetCode;

/*  108. Convert Sorted Array to Binary Search Tree
 *   https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * */

public class SortedArray2BinarySearchTree108 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return add(nums, 0, nums.length - 1);
    }

    public TreeNode add(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = add(nums, left, mid - 1);
        head.right = add(nums, mid + 1, right);
        return head;
    }
}
