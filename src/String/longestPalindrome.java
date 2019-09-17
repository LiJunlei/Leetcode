package String;

// time: O(n^2)  space: O(1)
public class longestPalindrome {
    String res = "";
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return res;
        for(int i = 0; i < s.length(); i++){
            palindromeHelper(s,i,i);
            palindromeHelper(s,i,i+1);
        }
        return res;
    }
    public void palindromeHelper(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1,right);
        if(cur.length() > res.length()) res = cur;
    }
}