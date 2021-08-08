package LeetCode;

/*  105. Construct Binary Tree from Preorder and Inorder Traversal
 *   https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * */

public class BinaryTreeFromPreorderInorderTraversal105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return subTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode subTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pr < pl || ir < il) return null;
        TreeNode head = new TreeNode(preorder[pl]);
        System.out.println(head.val);
        int cut = il;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == preorder[pl]) {
                cut = i;
                break;
            }
        }
        System.out.println(pl + " " + pr + " " + il + " " + ir + " " + cut);
        System.out.println();
        head.left = subTree(preorder, pl + 1, pl + cut - il, inorder, il, cut - 1);
        head.right = subTree(preorder, pl + cut - il + 1, pr, inorder, cut + 1, ir);
        return head;
    }

    public static void main(String[] args) {
        BinaryTreeFromPreorderInorderTraversal105 binary = new BinaryTreeFromPreorderInorderTraversal105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        binary.buildTree(preorder, inorder);
    }
}
