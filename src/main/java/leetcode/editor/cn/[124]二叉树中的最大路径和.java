//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 697 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution124 {

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        function(root);
        return max;
    }

    private int function(TreeNode parent) {

        if (parent == null) {
            return 0;
        }

        int leftMax = Math.max(function(parent.left),0);
        int rightMax = Math.max(function(parent.right),0);

        max =Math.max(max, parent.val + leftMax + rightMax);
        return parent.val + Math.max(leftMax, rightMax);
    }

//    private int function(TreeNode root, int maxPathSum) {
//        if (root == null) {
//            return maxPathSum;
//        }
//        int leftV = root.left == null || root.left.val < 0 ? 0 : root.left.val;
//        int rightV = root.right == null || root.right.val < 0 ? 0 : root.right.val;
//
//        maxPathSum = Math.max(maxPathSum, leftV + rightV + root.val);
//        int leftMaxPathSum = function(root.left, maxPathSum);
//        int rightMaxPathSum = function(root.right, maxPathSum);
//        maxPathSum = Math.max(leftMaxPathSum, rightMaxPathSum);
//        return maxPathSum;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
