package ArrayChar;

import java.util.Arrays;


//           0  1  2  3  4  5
//  arr[] = {1, 1, 1  2, 3, 4}
//                    |
// res             1
// count              1
//maxNum     1        3
// time: O(nlogn)  space: O(1)
public class mostFrequent {
    static int mostFrequent(int[] array){
        Arrays.sort(array);
        if(array.length < 1) return Integer.MIN_VALUE;
        int count = 1, maxNum = 1, res = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i-1] == array[i]){
                count++;
            }else{
                if(count > maxNum){
                    res = array[i-1];
                    maxNum = count;
                }
                count = 1;
            }
        }
        // consider the last element
        if(count > maxNum){
            res = array[array.length - 1];
            maxNum = count;
        }
        return res;
    }

    public static void main(String[] args){
        int array[] = {1,5,2,1,3,2,1};
        System.out.println(mostFrequent(array));
    }
}

