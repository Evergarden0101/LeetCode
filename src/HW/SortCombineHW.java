package HW;

import java.util.Arrays;
import java.util.Comparator;

public class SortCombineHW {
    public String solution(int[] nums) {
        if (nums == null) return "-1";
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = "" + nums[i];
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0, j = 0;
                while (o1.charAt(i) == o2.charAt(j)) {
                    if (i == j && i == o1.length() - 1 && j == o2.length() - 1) {
                        break;
                    }
                    i = (i + 1) % o1.length();
                    j = (j + 1) % o2.length();
                }
                return o1.charAt(i) - o2.charAt(j);
            }
        });
        String ans = "";
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
            ans += s[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        SortCombineHW sortCombineHW = new SortCombineHW();
        int[] nums = {453, 4536, 101, 9999};
        System.out.println(sortCombineHW.solution(nums));
    }
}
