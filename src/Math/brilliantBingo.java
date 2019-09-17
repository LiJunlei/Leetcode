package Math;

import java.util.HashSet;
// time:
public class brilliantBingo {
    public static int brilliantBingo(int num){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        while(set.size() < 10){
            count++;
            int dummy = num * count;
            while(dummy != 0){
                int temp = dummy % 10;
                set.add(temp);
                dummy = dummy/10;
            }
        }
        return count;
    }
    public static void main(String[] arg){
        int num = 7892;
        System.out.println(brilliantBingo(num));
    }
}
