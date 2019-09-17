package Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 */
/*  例子：  target 6.75
*               6
*            /     \
*           3       9
*         /   \   /   \
*        1     5 7     11
*         \       \    /
*          2       8  10
*
*   思路： 1， 找到最近Node  -> findClosest()
*         2,  用2个stack 分别存 小于 target的Node & 大于target的 Node
*             ( 因为 Tree 是有向图， 需要容器存放遍历到的Node)
*         3， 额外添加步骤1 中遗漏 的  prev & next 并比较（执行步骤1时是2选1，一定有数值相近但被遗漏的Node）
*            -> prevAdd() & nextAdd()
 */
public class ClosestKValues {

    //Definition of TreeNode:
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Stack<TreeNode> prev = new Stack<>();
            Stack<TreeNode> next = new Stack<>();
            TreeNode closestNode = root;
            findClosest(closestNode, prev, next, target);
            List<Integer> res = new ArrayList<>();

            while (res.size() != k) {
                double distancePrev = prev.isEmpty() ? Double.MAX_VALUE : Math.abs(prev.peek().val - target);
                double distanceNext = next.isEmpty() ? Double.MAX_VALUE : Math.abs(next.peek().val - target);
                if (distancePrev < distanceNext) {
                    res.add(0, prev.peek().val);
                    prevAdd(prev);
                } else {
                    res.add(next.peek().val);
                    nextAdd(next);
                }
            }
            return res;
        }

        private void findClosest(TreeNode node, Stack<TreeNode> prev, Stack<TreeNode> next, double target) {
            while (node != null) {
                if (node.val < target) {
                    prev.push(node);
                    node = node.right;
                } else {
                    next.push(node);
                    node = node.left;
                }
            }
        }

        private void prevAdd(Stack<TreeNode> prev) {
            TreeNode curNode = prev.pop().left;
            while (curNode != null) {
                prev.push(curNode);
                curNode = curNode.right;
            }
        }

        private void nextAdd(Stack<TreeNode> next) {
            TreeNode curNode = next.pop().right;
            while (curNode != null) {
                next.push(curNode);
                curNode = curNode.left;
            }
        }
    }
}