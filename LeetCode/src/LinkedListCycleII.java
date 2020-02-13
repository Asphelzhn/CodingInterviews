/**
 * Linked List Cycle II
 * 描述
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;

                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
