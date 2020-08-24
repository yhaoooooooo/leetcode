//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1203 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode f = l1;
        ListNode f2 = l2;

        ListNode firtNode = null;
        if (f == null) {
            return f2;
        }

        if (f2 == null) {
            return f;
        }


        if (f.val >= f2.val) {
            firtNode = f2;
        } else {
            firtNode = f;
        }

        while (f != null && f2 != null) {

            ListNode preF1 = null;

            while (f != null && f2 != null  && f.val < f2.val ) {
                preF1 = f;
                f = f.next;
            }

            if (preF1 != null ) {
                preF1.next = f2;
            }


            ListNode preF2 = null;
            while (f != null && f2 != null && f.val >= f2.val ) {
                preF2 = f2;
                f2 = f2.next;
            }

            if (preF2 != null ) {
                preF2.next = f;
            }

        }

        return firtNode;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)
