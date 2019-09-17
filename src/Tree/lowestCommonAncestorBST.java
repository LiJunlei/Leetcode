package Tree;

public class lowestCommonAncestorBST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        }
    }
}