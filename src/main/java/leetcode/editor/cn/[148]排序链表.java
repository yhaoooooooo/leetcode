//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 703 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution148 {


    public static void main(String[] args) {
        Solution148 solution148 = new Solution148();
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
//        listNode.next.next.next = new ListNode(3);


        listNode = solution148.sortList(listNode);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode sortList(ListNode head) {

        //链表使用快慢指针方式找到中点。
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPoint = head, fastPoint = head.next;

        while (fastPoint != null && fastPoint.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }

        ListNode midNode = slowPoint;
        ListNode rightHeadNode = midNode.next;
        midNode.next = null;

        head = sortList(head);
        rightHeadNode = sortList(rightHeadNode);

        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        while (head != null && rightHeadNode != null) {
            if (head.val >= rightHeadNode.val) {
                tmp.next = rightHeadNode;
                rightHeadNode = rightHeadNode.next;
            } else {
                tmp.next = head;
                head = head.next;
            }

            tmp = tmp.next;
        }


       tmp.next = head == null ? rightHeadNode : head;
        return listNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
