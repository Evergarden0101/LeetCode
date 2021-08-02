package HW;

import java.util.Scanner;

public class GoodFriendHW {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (int j = i + 1; j < n; j++) {
                if (height[j] > height[i]) {
                    idx = j;
                    break;
                }
            }
            System.out.print(idx + " ");
        }
    }
}
