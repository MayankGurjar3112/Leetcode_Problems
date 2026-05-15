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
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode start = new ListNode(-6000, head);
        ListNode pre = start;

        while (cur != null) {
            ListNode temp = start;
            while (temp.next.val < cur.val)
                temp = temp.next;
            if (temp.next != cur) {
                pre.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return start.next;
    }
}