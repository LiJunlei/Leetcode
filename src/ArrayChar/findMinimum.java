package ArrayChar;
// 如何 使用 swap method.
// output ==  4 ？
// time ?  space ?
public class findMinimum {
    public static int findMinimum(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int leftMostZero = 0, rightMostOne = 0;
        int count = 0;
        while(leftMostZero < len && rightMostOne < len) {
            while (leftMostZero < len && nums[leftMostZero] == 1) {
                leftMostZero++;
            }
            // 解释下。
            while (rightMostOne <= leftMostZero || (rightMostOne < len && nums[rightMostOne] == 0) ||
                    (rightMostOne + 1 < len && rightMostOne - leftMostZero < 2 && nums[rightMostOne] == 1 && nums[rightMostOne + 1] == 1)) {
                rightMostOne++;
            }
            if (leftMostZero < len && rightMostOne < len && nums[leftMostZero] == 0 && nums[rightMostOne] == 1) {
                while (rightMostOne - leftMostZero > 2) {
                    count++;
                    nums[rightMostOne] = 0;
                    nums[rightMostOne - 2] = 1;
                    rightMostOne -= 2;
                }
                nums[leftMostZero++] = 1;
                nums[rightMostOne++] = 0;
                count++;
                for (int i = 0; i < len; i++) {
                    System.out.print(" " + nums[i] + " ");
                }
                System.out.println();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 0, 1, 1, 1, 0, 0, 0, 0, 1};
        System.out.println(findMinimum(list));
    }
}