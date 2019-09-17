package ArrayChar;
// given an array of 1 and 0, count the minimum number of change in positions such that all 1's are aligned to left and 0's to right.\
// Positions can be changed only with the nearby 2 elements.
//         0  1  2  3  4  5  6  7  8  9
// nums    1, 0, 1, 1, 1, 0, 0, 0, 0, 1
//  LM0                   |
//  RM1                               |
// count                  4
public class minSwaps {
    public static int minSwaps(int[] nums){
        int leftMostZero = 0, rightMostOne = 0;
        int len = nums.length;
        int count = 0;
        while(leftMostZero < len && rightMostOne < len){
            while(leftMostZero < len - 1 && nums[leftMostZero] == 1){
                leftMostZero++;
            }
            while(rightMostOne < len - 1 && (nums[rightMostOne] == 0 || rightMostOne <= leftMostZero || (nums[rightMostOne] == 1 && nums[rightMostOne + 1] == 1))){
                rightMostOne++;
            }
            while( leftMostZero < len && rightMostOne < len && rightMostOne > leftMostZero){
                if(rightMostOne - leftMostZero >= 2){
                    swap(nums, rightMostOne - 2, rightMostOne, count);
                }else{
                    swap(nums, leftMostZero, rightMostOne, count);
                }
            }
            if (leftMostZero != rightMostOne && nums[leftMostZero] == nums[rightMostOne]){
                break;
            }
        }
        return count;
    }
    public static void swap(int[] nums, int left, int right, int count){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        right = left;
        count++;
    }
    public static void main(String[] arg){
        int[] nums = new int[]{1, 0, 1, 0, 1, 0, 0, 0, 1};
        System.out.println(minSwaps(nums));
    }
}
