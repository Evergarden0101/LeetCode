package LeetCode;/*  409. Longest Palindrome
*   Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
*   Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*   给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
*   在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
*   https://leetcode-cn.com/problems/longest-palindrome/
* */

import java.util.HashMap;

public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int ans=0;
        HashMap<Character,Integer> hash=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hash.containsKey(s.charAt(i))){
                hash.put(s.charAt(i),hash.get(s.charAt(i))+1);
            }else {
                hash.put(s.charAt(i),1);
            }
        }
        boolean flag=true;
        for(char i:hash.keySet()){
            System.out.println(i);
            ans+=i/2*2;
            if(i%2==1&&flag){
                ans++;
                flag=false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindrome409 longestPalindrome=new LongestPalindrome409();
        System.out.println(longestPalindrome.longestPalindrome("abdadwada"));
    }
}
