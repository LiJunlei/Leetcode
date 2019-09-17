package String;

// Time complexity : O(S) , where S is the sum of all characters in all strings.
// Space complexity :O(1). We only used constant extra space.
public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
            }
        }
        return prefix;
    }
    public static void main(String[] arg){
        String[] strs = {"perfect", "performance", "peak"};
        System.out.println(longestCommonPrefix(strs));
    }
}