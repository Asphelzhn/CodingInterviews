/**
 * Remove Duplicates from Sorted List
 * 描述
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        for (ListNode prev = head, cur = head.next; cur != null; cur = prev.next) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }
        return head;
    }
}
