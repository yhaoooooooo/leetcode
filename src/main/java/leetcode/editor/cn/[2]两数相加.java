//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4788 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import javax.xml.soap.Node;
import java.awt.geom.Rectangle2D;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution22 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (flag ? 1: 0);
            tmp.val = sum % 10;
            if (sum >= 10) {
                flag = true;
            } else {
                flag = false;
            }
            tmp.next = new ListNode(0);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            tmp.val = l1.val;
            tmp.next = new ListNode(0);
            tmp = tmp.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            tmp.val = l2.val;
            tmp.next = new ListNode(0);
            tmp = tmp.next;
            l2 = l2.next;
        }



        ListNode preNode = null;
        while (listNode != null) {
            ListNode nextNode = listNode.next;
            listNode.next = preNode;
            preNode = listNode;
            listNode = nextNode;
        }

        while (preNode != null && preNode.val == 0) {
            preNode = preNode.next;
        }
        return  preNode;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
