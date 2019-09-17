package ArrayChar;

import java.util.HashSet;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for(Integer i : nums1){
            set.add(i);
        }
        for(Integer j : nums2){
            if(set.contains(j)){
                res.add(j);
            }
        }
        int[] ans = new int[res.size()];
        int count = 0;
        for(Integer num : res){
            ans[count++] = num;
        }
        return ans;
    }
}

//.         0 1 2 3 4
// nums1 = [4,5,9]
//   i            |
// nums2 = [4,4,8,9,9]
//   j            |
//   res   [4,9]