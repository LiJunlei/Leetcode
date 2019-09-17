package DynamicProgramming;

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            int left = 0, right = maxLen;
            while(left < right){
                int mid = left + (right - left)/2;
                if(dp[mid] < nums[i]){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
            if(left == maxLen) maxLen++;
        }
        return maxLen;
    }
}


// time: O(nlogn)  space: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            int left = 0, right = maxLen;
            while(left < right){
                int mid = left + (right - left)/2;
                if(dp[mid] < nums[i]){
                    left = mid + 1;
                }else right = mid;
            }
            //更新dp[], 结果可能不是正确的值，但是保证头尾正确，长度正确
            dp[left] = nums[i];
            if(left == maxLen) maxLen++;
        }
        return maxLen;
    }
}

//         0 1 2 3 4 5  6  7  8. 9 10
//       [10,9,2,5,3,7,101,18,20,21,9]
// i                                |
// left          |
// right         |
// mid           |
//dp     [2,3,7,9,20,21,]
// maxLen               6



///       0 1 2 3 4 5  6   7
// nums [10,9,2,5,3,7,101,18]

// dp   [ 1,1,1,2,2,3, 4, 4]


// time: O(n^2)  space: O(n)
//class Solution{
//    public int lengthOfLIS(int[] nums){
//        // dp[i]: relatively maxLen in first i element
//        int[] dp = new int[nums.length];
//        int maxLen = 0;
//        for(int i = 0; i < nums.length; i++){
//            int len = 1;
//            for(int j = 0; j < i; j++){
//                if(nums[j] < nums[i]){
//                    len = Math.max(len, dp[j] + 1);
//                }
//            }
//            dp[i] = len;
//            maxLen = Math.max(maxLen, dp[i]);
//        }
//        return maxLen;
//    }
//}

