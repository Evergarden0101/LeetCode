package HW;

public class LongestString {
    public String solution(String in) {
        if (in == null) return null;
        int n = in.length();
        int len = 1, start = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expand(in, i, i);
            int len2 = expand(in, i, i + 1);
            if (len1 > len) {
                len = len1;
                start = i - len / 2;
            }
            if (len2 > len) {
                len = len2;
                start = i - len / 2 + 1;
            }
        }
        return in.substring(start, start + len);
    }

    public int expand(String in, int start, int end) {
        while (start >= 0 && end <= in.length() - 1 && in.charAt(start) == in.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        LongestString longestString = new LongestString();
        System.out.println(longestString.solution("bababc"));
    }
}
