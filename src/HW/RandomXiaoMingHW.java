package HW;

import java.util.*;

public class RandomXiaoMingHW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            HashSet<Integer> hs = new HashSet<>();
            while (n-- > 0) {
                int in = sc.nextInt();
                hs.add(in);
            }
            Integer[] ans=hs.toArray(new Integer[0]);
            Arrays.sort(ans);
            for (int i:ans){
                System.out.println(i);
            }
        }
    }
}
