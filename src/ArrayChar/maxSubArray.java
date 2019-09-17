package ArrayChar;

//nums   [-2,1,-3,4,-1,2,1,-5,4]
// sum    -2 1 -2 4  3 5 6  1 5
// res.   -2 1  1 4  4 5 6  6 5

//time: O(n)   space: O(1)
public class maxSubArray {
    public static int maxSubArray(int[] nums){
        int res = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], nums[i] + sum);
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] arg){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}