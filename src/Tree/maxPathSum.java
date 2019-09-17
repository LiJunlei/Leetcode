package Tree;

class maxPathSum {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 创建global variable 时刻更新最大值。
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfsHelper(root);
        return max;
    }
    private int dfsHelper(TreeNode root){
        // dfsHelper中返回左右两边最大加和
        if(root == null) return 0;
        // call recursion, 单边加和取非负数，
        int left = Math.max(dfsHelper(root.left),0);
        int right = Math.max(dfsHelper(root.right),0);

        //时刻更新最大值
        max = Math.max(max, left + right + root.val);
        //返回左右两边最大加和
        return Math.max(left, right) + root.val;
    }
}

