package HW;

import java.util.Scanner;

public class MonkeyClimbHW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(climb(n));
    }

    public static int climb(int n) {
        if (n == 1 || n == 2) return 1;
        else if (n == 3) return 2;
        else return climb(n - 3) + climb(n - 1);
    }
}
