package ArrayChar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 0 || intervals[0].length == 0) return intervals;
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for(int[] interval : intervals){
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] arg){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }
}

// i
// 0  [[1,2],
//.1   [3,6],
//.2   [8,10],
//.3   [15,18]]

// i  1
// j  i
//res[[1,2],[3,6]]