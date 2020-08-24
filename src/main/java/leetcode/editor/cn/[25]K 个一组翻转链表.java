//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 675 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {


        ListNode node = head;
        int num = 0;
        List<ListNode> list = new ArrayList<ListNode>();

        ListNode firtNode = null;
        while (node != null){
            if (num % k == 0 ) {
                list.add(node);
            }
            num++;

            if (num == k || (num <= k && node.next == null)) {
                firtNode = node;
            }

            node = node.next;

        }



        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ListNode listNode = list.get(i);
                num = 0;

                ListNode next = null;
                ListNode pre = null;
                ListNode lastGroupEndNode = listNode;
                while (listNode != null && num < k) {

                    if (num == 0 )  {
                        pre = i < list.size() - 2 ? list.get(i+1) : null;
                    } else {
                        pre = listNode;
                    }
                    next = listNode.next;

                    listNode.next = pre;
                    pre = listNode;
                    listNode = next;
                    num ++;
                }

            }
        }

        return firtNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
