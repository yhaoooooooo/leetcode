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
import java.util.ArrayList;
import java.util.List;
//leetcode submit region begin(Prohibit modification and deletion)



// Definition for singly-linked list.

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        return null;
    }
    /*
    当前方法没有考虑 未满足k长度的 不翻转的情况
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = splitList(head, k);
        ListNode newListNode =  reverseAndMerge(list, 0 , list.size() - 1);
        return newListNode;
    }

    private ListNode reverseAndMerge(List<ListNode> list, int left, int right) {
        ListNode listNode = null;
        if (left >= right) {
            listNode = list.get(left);
            listNode = reverseList(listNode);
        } else {
            int mid = (left + right) / 2;
            ListNode leftNode = reverseAndMerge(list, left, mid);
            ListNode rightNode = reverseAndMerge(list, mid + 1, right);
            listNode = leftNode;
            while (leftNode != null && leftNode.next != null) {
                leftNode = leftNode.next;
            }
            leftNode.next = rightNode;
        }
        return listNode;
    }
    private ListNode reverseList(ListNode listNode) {
        ListNode pre = null;
        while (listNode != null) {
            ListNode tmp = listNode;
            ListNode next = listNode.next;
            tmp.next = pre;
            pre = listNode;
            listNode = next;
            if (next == null) {
                return tmp;
            }
        }
        return null;
    }
    private List<ListNode> splitList(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        ListNode pre = null;
        int index = 0;
        while (tmp != null) {
            if (index % k == 0) {
                list.add(tmp);
                if (pre != null) {
                    pre.next = null;
                }
            }
            pre = tmp;
            tmp = pre.next;
            index++;
        }
        return list;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
