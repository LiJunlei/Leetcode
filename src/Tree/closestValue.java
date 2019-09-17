package Tree;

// time: O(H) , space: O(1)

public class closestValue {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public int closestValue(TreeNode root, double target){
        int res = root.val;
        while(root != null){
            if(Math.abs(root.val - target) < Math.abs(res - target)){
                res = root.val;
            }
            if(root.val < target){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return res;
    }
}
