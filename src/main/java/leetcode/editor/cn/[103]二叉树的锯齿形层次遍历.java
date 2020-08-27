//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 257 👎 0

package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution103 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        levelOrder(new ArrayList<TreeNode>(Arrays.asList(root)), 0);
        return result;
    }

    private void levelOrder(List<TreeNode> levelNodes, int c) {
        if (!levelNodes.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>(10);

            List<TreeNode> levenode = new ArrayList<TreeNode>();
            for (int i = 0; i < levelNodes.size(); i++) {
                if (levelNodes.get(i) != null) {
                    levenode.add(levelNodes.get(i).left);
                    levenode.add(levelNodes.get(i).right);
                }

                int p = c % 2 == 0 ? i : levelNodes.size() - 1 - i;
                if (levelNodes.get(p) != null) {
                    list.add(levelNodes.get(p).val);
                }

            }
            if (!list.isEmpty()){
                result.add(list);
            }
            levelOrder(levenode, ++c);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
