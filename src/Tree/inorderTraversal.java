package Tree;

import java.util.ArrayList;
import java.util.List;

// time : O(N)   space: average: O(logn), worst: O(n)
public class inorderTraversal {
     class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x){
             val = x;
         }
     }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfsHelper(root, res);
        return res;
    }
    private void dfsHelper(TreeNode root, List<Integer> res){
        if(root == null) return;
        dfsHelper(root.left, res);
        res.add(root.val);
        dfsHelper(root.right, res);
    }
}