package LeetCode;/*  763. Partition Labels
*   You are given a string s.
*   Partition the string into as many parts as possible so that each letter appears in at most one part.
*   Return a list of integers representing the size of these parts.
*   字符串 S 由小写字母组成。
*   把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
*   返回一个表示每个字符串片段的长度的列表。
*   https://leetcode-cn.com/problems/partition-labels/
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Character, Integer> hash=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hash.put(s.charAt(i),i);
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            end=hash.get(s.charAt(i))>end?hash.get(s.charAt(i)):end;
            if(end<=i){
                ans.add(end-start+1);
                start=end+1;
                end++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels763 partitionLabels=new PartitionLabels763();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
