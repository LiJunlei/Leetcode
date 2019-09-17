package ArrayChar;

import java.util.ArrayList;
import java.util.List;


// when find a number i, flip the number at position i-1 to negative.
// if the number at position i-1 is already negative, i is the number that occurs twice.
// time: O(N).  space: O(1)
//        0  1  2  3 4 5  6  7
// nums  [4,-3,-2,-7,8,2,-3,-1]
//.                       |
// res [2,3]

public class findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length <= 1) return res;
        for(int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]);
            if(nums[temp - 1] < 0){
                res.add(temp);
            }else{
                nums[temp - 1] *= (-1);
            }
        }
        return res;
    }
}


