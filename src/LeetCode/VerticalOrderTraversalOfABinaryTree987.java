package LeetCode;

/*  987. Vertical Order Traversal of a Binary Tree
 *   https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 * */

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree987 {
    static class TreeNode {
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

    int[][] hash = new int[1000][3];

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int x = 0, y = 0, idx = 0;
        idx = calPosition(root, x, y, idx);
        int[][] ans = new int[idx][3];
        for (int i = 0; i < idx; i++) {
            ans[i] = hash[i];
//            System.out.println(ans[i][0]);
        }
//        System.out.println();
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[2]!=b[2]){
                    return a[2]-b[2];
                }else if(a[1]!=b[1]){
                    return a[1]-b[1];
                }else {
                    return a[0]-b[0];
                }
            }
        });
//        for(int i=0;i<idx;i++){
//            System.out.println(ans[i][0]);
//        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(ans[0][0]);
        for (int i = 1; i < idx; i++) {
            if (ans[i][2] == ans[i - 1][2]) {
                cur.add(ans[i][0]);
            }else {
                list.add(cur);
                cur=new ArrayList<>();
                cur.add(ans[i][0]);
            }
        }
        list.add(cur);
        return list;
    }

    public int calPosition(TreeNode p, int x, int y, int idx) {
        int[] pair = new int[3];
        pair[0] = p.val;
        pair[1] = x;
        pair[2] = y;
        hash[idx++] = pair;

        if (p.left != null) {
            idx = calPosition(p.left, x + 1, y - 1, idx);
        }
        if (p.right != null) {
            idx = calPosition(p.right, x + 1, y + 1, idx);
        }
        return idx;
    }

    public static void main(String[] args) {
        VerticalOrderTraversalOfABinaryTree987 verticalOrderTraversalOfABinaryTree = new VerticalOrderTraversalOfABinaryTree987();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        root.right = right;
        System.out.println(verticalOrderTraversalOfABinaryTree.verticalTraversal(root));
    }


}
