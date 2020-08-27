//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 713 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pParents = new ArrayList<TreeNode>();
        List<TreeNode> qParents = new ArrayList<TreeNode>();
        TreeNode p1 = findParents(root, p, pParents);
        TreeNode p2 = findParents(root, q, qParents);

        if (p1 != null) {
            pParents.add(p1);
        }
        if (p2 != null) {
            qParents.add(p2);
        }


        for (int i = 0; i < pParents.size() ; i++) {
            if (qParents.contains(pParents.get(i))) {
                return pParents.get(i);
            }
        }

        return null;
    }

    private TreeNode findParents(TreeNode parent, TreeNode p, List<TreeNode> pParents) {
        if (parent == null) {
            return null;
        }


        if (parent == p) {
            return parent;
        }

        if (parent.left == p || parent.right == p) {
            pParents.add(p);
            return parent;
        }
        TreeNode p1 = findParents(parent.left, p, pParents);
        if (p1 != null) {
            pParents.add(p1);
            return parent;
        }
        TreeNode p2 = findParents(parent.right, p, pParents);
        if (p2 != null) {
            pParents.add(p2);
            return parent;
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }