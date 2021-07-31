package LeetCode;/*  5. Longest Palindromic Substring
 *   Given a string s, return the longest palindromic substring in s.
 *   给你一个字符串 s，找到 s 中最长的回文子串。
 *   https://leetcode-cn.com/problems/longest-palindromic-substring/
 * */

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if(s.length()==0)   return "";
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int cou1=expand(s,i,i);
            int cou2=expand(s,i,i+1);
            int len=cou1>cou2?cou1:cou2;
            if(len>end-start+1){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int expand(String s,int left,int right) {
        int l=left,r=right;
        while(l>=0&&r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }else {
                break;
            }
        }
        return r-l-1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring5 longestPalindromicSubstring=new LongestPalindromicSubstring5();
        System.out.println(longestPalindromicSubstring.longestPalindrome("ac"));
    }
}
