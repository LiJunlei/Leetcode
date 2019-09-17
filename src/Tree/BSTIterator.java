package Tree;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 *这是一个非常通用的利用 stack 进行 Binary Tree Iterator 的写法。
 *
 *         stack 中保存一路走到当前节点的所有节点，stack.peek() 一直指向 iterator 指向的当前节点。
 *         因此判断有没有下一个，只需要判断 stack 是否为空
 *         获得下一个值，只需要返回 stack.peek() 的值，并将 stack 进行相应的变化，挪到下一个点。
 *
 *         挪到下一个点的算法如下：
 *
 *         如果当前点存在右子树，那么就是右子树中“一路向西”最左边的那个点
 *         如果当前点不存在右子树，则是走到当前点的路径中，第一个左拐的点
 *         访问所有节点用时O(n)，所以均摊下来访问每个节点的时间复杂度时O(1)
 */

public class BSTIterator {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        if(stack.isEmpty()){
            return null;
        }
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        while(right != null){
            stack.push(right);
            right = right.left;
        }
        return node;
    }
}