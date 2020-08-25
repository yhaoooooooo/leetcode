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

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();

        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = solution206.reverseList2(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 遍历
     * @param head
     * @return
     */
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
