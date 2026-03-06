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
    public ListNode mergeNodes(ListNode head) {
        ListNode tempA = head.next;
        ListNode h = new ListNode(0);
        ListNode tempB = h;

        while (tempA.next != null) {
            if (tempA.val == 0) {
                tempB.next = new ListNode(0);
                tempB = tempB.next;
            } else
                tempB.val += tempA.val;
            tempA = tempA.next;
        }

        return h;
    }
}