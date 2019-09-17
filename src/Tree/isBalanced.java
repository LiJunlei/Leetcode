package Tree;

// Time: O(n) n = depth, space: O(1)
public class isBalanced {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        return dfsHelper(root) != -1;
    }
    private int dfsHelper(TreeNode root){
        if(root == null) return 0;
        int left = dfsHelper(root.left);
        int right = dfsHelper(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
