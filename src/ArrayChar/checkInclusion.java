package ArrayChar;
// s1 " a d c "
// s2 = "d c d a"
// i    [    |
//       0 1 2 3
//dict =[0,1,0,0]
// time: O(len1 + len2)  space : O(1)
public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;
        int[] dict = new int[26];
        for(int i = 0; i < len1; i++){
            dict[s1.charAt(i) - 'a']++;
            dict[s2.charAt(i) - 'a']--;
        }
        if(isAllZero(dict, s2, len1,len1 - 1)) return true;
        for(int i = len1; i < len2; i++){
            dict[s2.charAt(i- len1) - 'a']++;
            dict[s2.charAt(i) - 'a']--;
            if(isAllZero(dict, s2, len1,i)) return true;
        }
        return false;
    }
    public boolean isAllZero(int[] dict, String s2, int len1, int endIdx){
        for(int i = endIdx - len1 + 1; i <= endIdx; i++){
            int temp = s2.charAt(i) - 'a';
            if(dict[temp] != 0){
                return false;
            }
        }
        return true;
    }
}

