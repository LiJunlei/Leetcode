package String;

public class minWindow {
    public static String minWindow(String s, String t){
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int startIdx = -1;
        int minLen = Integer.MAX_VALUE;
        int disMatchCount = t.length();
        int[] dict = new int[128];
        for(char c: t.toCharArray()){
            dict[c]++;
        }
        int left = 0, right = 0;
        while(right < s.length()){
            while(right < s.length() && disMatchCount > 0){
                if(dict[s.charAt(right)] > 0){
                    disMatchCount--;
                }
                dict[s.charAt(right)]--;
                right++;
            }
            while(disMatchCount == 0){
                if(dict[s.charAt(left)] == 0){
                    disMatchCount++;
                }
                dict[s.charAt(left)]++;
                left++;
            }
            if(right - left + 1 < minLen){
                startIdx = left - 1;
                minLen = right - left + 1;
            }
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}


// S =      "ADOBECODEBANC"
// startIdx |
// left      |
// right     |
// minLen
//
// T = "A B C"

// dic [1,1,1]
