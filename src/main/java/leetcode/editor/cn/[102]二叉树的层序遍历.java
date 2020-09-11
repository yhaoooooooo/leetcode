//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 628 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution102 {


    private List<List<Integer>> datas = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return datas;
        }
        datas.add(new ArrayList<>(Arrays.asList(root.val)));
        function(new ArrayList<>(Arrays.asList(root)));
        return datas;
    }

    private void function(List<TreeNode> parents) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < parents.size(); i++) {
            TreeNode treeNode = parents.get(i);
            if (treeNode.left != null) {
                list.add(treeNode.left);
                data.add(treeNode.left.val);
            }
            if (treeNode.right != null) {
                list.add(treeNode.right);
                data.add(treeNode.right.val);
            }
        }
        if (!list.isEmpty()) {
            datas.add(data);
            function(list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
