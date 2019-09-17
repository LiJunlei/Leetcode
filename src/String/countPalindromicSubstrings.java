package String;

public class countPalindromicSubstrings {
    static int count = 1;
    public static int countPalindromicSubstrings(String s){
        if(s == null || s.length() == 0) return 0;
        for(int i = 1; i < s.length(); i++){
            countHelper(s,i,i);
            countHelper(s,i-1,i);
        }
        return count;
    }
    public static void countHelper(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
    }

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(countPalindromicSubstrings(s));
    }
}
