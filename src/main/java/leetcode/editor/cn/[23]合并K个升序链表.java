//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 870 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution23 {


    /**
     * 两种思路：
     * 1. 优先级队列， 将lists的k个head 放到优先级队列中（会进行比较），拿出最小，把最小的next再放进去，直到取空
     * 2. lists的分而治之
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0 ) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = new ListNode(0), tmp = head;
        while (true) {
            ListNode minNode = getMin(lists);
            if (minNode == null) {
                break;
            }
            tmp.next = minNode;
            tmp = tmp.next;
        }
        return head.next;
    }

    private ListNode getMin(ListNode[] lists) {


        int maxPosition = 0;

        ListNode minNode = null;

        for (int i = 0; i < lists.length; i++) {
            ListNode tmp = lists[i];
            if (tmp == null) {
                continue;
            }

            if (minNode == null || tmp.val < minNode.val) {
                minNode = tmp;
                maxPosition = i;
            }
        }

        if (minNode != null) {
            lists[maxPosition] = minNode.next;
        }

        return minNode;
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
