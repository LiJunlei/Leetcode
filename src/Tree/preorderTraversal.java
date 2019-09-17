package Tree;

import java.util.ArrayList;
import java.util.List;

// time : O(N)   space: average: O(logn), worst: O(n)

public class preorderTraversal{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        dfsHelper(root, res);
        return res;
    }
    private void dfsHelper(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        dfsHelper(root.left, res);
        dfsHelper(root.right, res);
    }
}