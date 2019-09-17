package DynamicProgramming;

/*
 *【Q 53. Maximum Subarray 】
 * Find the contiguous subarray within an array (containing at least one number) which has
 * the largest sum. For example, given the array [-2,1,-3,4,-1,2,1,-5,4],the contiguous
 *subarray [4,-1,2,1] has the largest sum = 6.
 */
// time: O(n)   space: O(n)

public class MaximumSubarray {
    public int MaximumSubarray(int[] nums) {
        int maxToCur = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxToCur = Math.max(nums[i],maxToCur+nums[i]);
            res = Math.max(res,maxToCur);
        }
        return res;
    }
}

