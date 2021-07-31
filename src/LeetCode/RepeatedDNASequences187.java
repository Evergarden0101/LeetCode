package LeetCode;/*  187. Repeated DNA Sequences
 *  The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *      - For example, "ACGAATTCCG" is a DNA sequence.
 *  When studying DNA, it is useful to identify repeated sequences within the DNA.
 *  Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 *  所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *  编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *  https://leetcode-cn.com/problems/repeated-dna-sequences/
 * */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hash=new HashSet<>();
        HashSet<String> ans=new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String cut=s.substring(i,i+10);
            if(hash.contains(cut)){
                ans.add(cut);
            }else {
                hash.add(cut);
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        RepeatedDNASequences187 repeatedDNASequences=new RepeatedDNASequences187();
        System.out.println(repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
