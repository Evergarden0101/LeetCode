package LeetCode;

/*  74. Search a 2D Matrix
 *   https://leetcode-cn.com/problems/search-a-2d-matrix/
 * */

public class Search2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = m - 1;
        while (x < n && y >= 0) {
            if (matrix[y][x] == target) return true;
            else if (matrix[y][x] > target) y--;
            else if (matrix[y][x] < target) x++;
        }
        return false;
    }
}
