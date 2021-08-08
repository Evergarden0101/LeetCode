package LeetCode;

/*  394. Decode String
 *   https://leetcode-cn.com/problems/decode-string/
 * */

public class DecodeString394 {
    int idx;

    public String decodeString(String s) {
        idx = 0;
//        while (idx < s.length()) {
//            System.out.println(s.charAt(idx)+" "+idx);
//            if (Character.isAlphabetic(s.charAt(idx))) {
//                ans += s.charAt(idx++);
//                continue;
//            }
//            String time = "";
//            while (Character.isDigit(s.charAt(idx))) {
//                System.out.println(s.charAt(idx)+" "+idx);
//                time += s.charAt(idx++);
//            }
//            System.out.println(time);
//            idx++;
//            ans += unplic(s, Integer.valueOf(time));
//            idx++;
//        }
        return unplic(s, 1);
    }

    public String unplic(String s, int time) {
        String ans = "";
        while (idx < s.length() && s.charAt(idx) != ']') {
            System.out.println(s.charAt(idx) + " " + idx);
            if (Character.isAlphabetic(s.charAt(idx))) {
                ans += s.charAt(idx++);
                continue;
            }
            String count = "";
            while (Character.isDigit(s.charAt(idx))) {
                count += s.charAt(idx++);
            }
            idx++;
            ans += unplic(s, Integer.valueOf(count));
            idx++;
        }
        String ele = ans.substring(0);
        while (--time > 0) {
            ans += ele;
        }
        return ans;
    }

    public static void main(String[] args) {
        DecodeString394 decodeString = new DecodeString394();
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
