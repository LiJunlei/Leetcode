package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum2 {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */

    //  Definition of TreeNode:
    public class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
         }
     }


    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfsHelper(root, target, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfsHelper(TreeNode root, int target,  ArrayList<Integer> path, List<List<Integer>> res){
        if(root == null) return;
        path.add(root.val);
        int sum = 0;
        for(int i = path.size() - 1; i >= 0; i--){
            sum += path.get(i);
            if(sum == target){
                res.add(new ArrayList<>(path.subList(i,path.size())));
            }
        }
        dfsHelper(root.left, target, path, res);
        dfsHelper(root.right, target, path, res);
        path.remove(path.size() - 1);
    }
}