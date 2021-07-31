package LeetCode;

import java.util.HashMap;

/*  290. Word Pattern
*   Given a pattern and a string s, find if s follows the same pattern.
*   Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
*   给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
*   这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
*   https://leetcode-cn.com/problems/word-pattern/
*  */
public class WordPattern290 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> ch=new HashMap<>();
        HashMap<String,Character> wd=new HashMap<>();
        String[] words=s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            if(ch.containsKey(c)){
                String word=ch.get(c);
                if(!word.equals(words[i])){
                    return false;
                }
            }else {
                if(wd.containsKey(words[i])){
                    return false;
                }else {
                    ch.put(c,words[i]);
                    wd.put(words[i],c);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern290 wordPattern=new WordPattern290();
        System.out.println(wordPattern.wordPattern("abba","dog dog dog dog"));
    }
}
