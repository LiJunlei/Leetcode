package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    public void backTracking(int[] candidates, int target, int startIdx, List<Integer> list, List<List<Integer>> res){
        if(target < 0){
            return;
        }
        else if(target == 0){
            res.add(new ArrayList<>(list));
        }else{
            for(int i = startIdx; i < candidates.length; i++){
                if(i > startIdx && candidates[i] == candidates[i-1]){
                    continue;
                }
                list.add(candidates[i]);
                backTracking(candidates, target - candidates[i], i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}