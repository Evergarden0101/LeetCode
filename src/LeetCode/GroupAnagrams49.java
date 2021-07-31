package LeetCode;/*  49. Group Anagrams
 *   Given an array of strings strs, group the anagrams together.
 *   You can return the answer in any order.
 *   An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *   给定一个字符串数组，将字母异位词组合在一起。
 *   可以按任意顺序返回结果列表。
 *   字母异位词指字母相同，但排列不同的字符串。
 *   https://leetcode-cn.com/problems/group-anagrams/
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (hash.containsKey(key)) {
                List<String> list = hash.get(key);
                list.add(s);
                hash.put(key, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                hash.put(key, list);
            }
        }
        return new ArrayList<List<String>>(hash.values());
    }

    public static void main(String[] args) {
        GroupAnagrams49 groupAnagrams = new GroupAnagrams49();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
