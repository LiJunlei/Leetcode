package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void backTracking(int[] candidates, int target, int startIdx, List<Integer> list, List<List<Integer>> res){
        if(target < 0) {
            return;
        }else if(target == 0){
            res.add(list);
        }else{
            for(int i = startIdx; i < candidates.length; i++){
                list.add(candidates[i]);
                backTracking(candidates, target - candidates[i], i, list, res);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}
