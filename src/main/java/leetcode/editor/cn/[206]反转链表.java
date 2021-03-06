//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1182 👎 0

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
class Solution206 {
    public ListNode reverseList(ListNode head) {

        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            ListNode lastNode = node.next;
            node.next = preNode;
            preNode = node;
            node = lastNode;
        }

        return preNode;
    }

    public ListNode reverseList2(ListNode head) {
        return reverseListByRecursionFunction(head, null);
    }

    private ListNode reverseListByRecursionFunction(ListNode node, ListNode preNode) {
        if (node != null) {
            ListNode nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;

            return reverseListByRecursionFunction(node, preNode);
        } else {
            return preNode;
        }
    }

}

//leetcode submit region end(Prohibit modification and deletion)
