//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 274 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution146 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l11 = reverselistNode(l1);
        ListNode l22 = reverselistNode(l2);

        ListNode beginNode = new ListNode(0);
        beginNode.next = new ListNode(0);
        ListNode newNode = beginNode.next;

        int isCarry = 0;
        while (l11 != null && l22 != null) {
            int val1 = l11.val;
            int val2 = l22.val;
            int sum = val1 + val2 + isCarry;
            isCarry = sum >= 10 ? 1 : 0;
            newNode.val = isCarry == 1 ? sum - 10 : sum;
            newNode.next = new ListNode(-1);
            newNode = newNode.next;
            l11 = l11.next;
            l22 = l22.next;
        }

        while (l11 != null) {
            int sum = l11.val + isCarry;
            isCarry = sum >= 10 ? 1 : 0;
            newNode.val = isCarry == 1 ? sum - 10 : sum;
            l11 = l11.next;
            newNode.next = new ListNode(-1);
            newNode = newNode.next;
        }

        while (l22 != null) {
            int sum = l22.val + isCarry;
            isCarry = sum >= 10 ? 1 : 0;
            newNode.val = isCarry == 1 ? sum - 10 : sum;
            l22 = l22.next;
            newNode.next = new ListNode(-1);
            newNode = newNode.next;
        }
        if (isCarry == 1) {
            newNode.val = 1;
            newNode.next = new ListNode(-1);
        }
        ListNode node = reverselistNode(beginNode.next);
        return node.next;
    }

    private ListNode reverselistNode(ListNode l1) {
        ListNode pre = null;
        ListNode current = l1;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
