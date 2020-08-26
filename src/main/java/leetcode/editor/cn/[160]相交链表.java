//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表 
// 👍 791 👎 0

package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution160 {


    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null) {
            return null;
        }
        if (headB == null) {
            return null;
        }
        ListNode tmpA = headA;
        ListNode tmpB = headB;

        ListNode intersectionNode = null;
        int cycleCount = 0;
        while (true) {
            if (tmpA == tmpB) {
                intersectionNode = tmpA;
                break;
            }
            if (tmpA.next == null) {
               cycleCount++;
                if (cycleCount > 1) {
                    break;
                }
               tmpA = headB;
            } else {
                tmpA = tmpA.next;
            }

            if (tmpB.next == null) {
                tmpB = headA;
            } else {
                tmpB = tmpB.next;
            }
        }

        return intersectionNode;
    }

    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode tmpA = headA;
        ListNode tmpB = headB;

        List<ListNode> container = new ArrayList<ListNode>();

        ListNode intersectionNode = null;
        while (tmpA != null && tmpB != null) {

            if (container.contains(tmpA)) {
                intersectionNode = tmpA;
                break;
            }
            container.add(tmpA);

            if (container.contains(tmpB)) {
                intersectionNode = tmpB;
                break;
            }
            container.add(tmpB);
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }

        if (intersectionNode != null) {
            return intersectionNode;
        }

        while (tmpA != null) {
            if (container.contains(tmpA)) {
                intersectionNode = tmpA;
                break;
            }
            tmpA = tmpA.next;
        }

        while (tmpB != null) {
            if (container.contains(tmpB)) {
                intersectionNode = tmpB;
                break;
            }
            tmpB = tmpB.next;
        }


        return intersectionNode;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
