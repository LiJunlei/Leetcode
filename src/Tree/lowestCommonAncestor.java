package Tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class lowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Method 1: recursion
    // Time: O(N) (N为node个数) Space： O（N）recursion 次数。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }
        // divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //conquer
        if (left != null && right != null) { // 左右子树都有值，（p,q一边一个）=> root为祖先
            return root;
        } else if (left != null) { // 只有左子树有值，（p,q都在左边）=> 最先遇到的node为祖先
            return left;
        } else if (right != null) { // 只有右子树有值，（p,q都在右边）=> 最先遇到的node为祖先
            return right;
        }
        return null;
    }

    //             3            p = 6. q = 0
//           /   \
//         5       1
//.      /   \    /  \
//.     6     2  0    8
//           / \
//.         7   4

//parent:    key:   3  5  1  0  8  6  2
//         value:   #  3  3  1  1  5  5
// stack:  |
// node      5  6. 2

// p       6 5 3 #
//ancestors: 6 5 3 0 1
// q.                  3


    // Method 2: iteration
    // Time: O(N) (N为node个数) Space： O（N）
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Stack<TreeNode> stack = new Stack<>();
            HashMap<TreeNode, TreeNode> parent = new HashMap<>();
            parent.put(root, null);
            stack.push(root);

            while (!parent.containsKey(p) || !parent.containsKey(q)) {

                TreeNode node = stack.pop();
                if (node.left != null) {
                    parent.put(node.left, node);
                    stack.push(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    stack.push(node.right);
                }
            }

            HashSet<TreeNode> ancestors = new HashSet<>();
            while (p != null) {
                ancestors.add(p);
                p = parent.get(p);
            }
            while (!ancestors.contains(q)) {
                q = parent.get(q);
            }
            return q;
        }
    }
}
