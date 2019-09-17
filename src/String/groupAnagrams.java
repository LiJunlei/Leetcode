package String;

import java.io.*;
import java.util.*;

public class groupAnagrams {
}
// Time Complexity:  O(NKlogK) , N is the length of strs, and  K is the maximum length of a string in strs
// Space Complexity:

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}



