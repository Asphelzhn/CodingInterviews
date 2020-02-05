/**
 * Odd Even Linked List
 * 描述
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(n) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * 分析
 * 创建两个新的空链表，遍历原始链表，把奇数位置的节点添加到第一个小链表，把偶数位置的节点添加到第二个小链表。
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        final ListNode oddDummy = new ListNode(0);
        final ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;

        int index = 1;
        while (head != null) {
            if (index  % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
            ++index;
        }

        odd.next = evenDummy.next;
        return oddDummy.next;
    }
}
