package HW;

/*  HJ67 24点游戏算法
 *   https://www.nowcoder.com/practice/fbc417f314f745b1978fc751a54ac8cb?tpId=37&&tqId=21290&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * */

import java.util.Scanner;

public class HJ67_24Point {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int[] nums = new int[4];
            int[] visited = new int[4];
            double sum = 0;
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                nums[i] = sc.nextInt();
                visited[i] = 0;
            }

            for (int i = 0; i < 4; i++) {
                visited[i] = 1;
                if (DFS(nums, visited, sum + nums[i], 24)) {
                    flag = true;
                    break;
                }
                visited[i] = 0;
            }
            System.out.println(flag);
        }
    }

    public static boolean DFS(int[] nums, int[] visited, double sum, int target) {
        System.out.println(sum);
        System.out.println("" + visited[0] + visited[1] + visited[2] + visited[3]);

        if (visited[0] + visited[1] + visited[2] + visited[3] == 4) {
            if (sum != target) return false;
            else return true;
        }
        for (int i = 0; i < 4; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (DFS(nums, visited, sum + nums[i], 24) ||
                        DFS(nums, visited, sum - nums[i], 24) ||
                        DFS(nums, visited, sum * nums[i], 24) ||
                        DFS(nums, visited, sum / nums[i], 24)) {
                    return true;
                }
                visited[i] = 0;
            }

        }
        return false;
    }
}
