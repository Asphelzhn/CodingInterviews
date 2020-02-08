/**
 * Rotate List
 * 描述
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->nullptr and k = 2, return 4->5->1->2->3->nullptr.
 * 分析
 * 先遍历一遍，得出链表长度len，注意k可能大于len，因此令k %= len。将尾节点next指针指向首节点，形成一个环，接着往后跑len-k步，从这里断开，就是要求的结果了。
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int len = 1;
        ListNode p = head;
        while (p.next != null) { // 求长度
            len++;
            p = p.next;
        }
        k = len - k % len;

        p.next = head; // 首尾相连
        for(int step = 0; step < k; step++) {
            p = p.next;  //接着往后跑
        }
        head = p.next; // 新的首节点
        p.next = null; // 断开环
        return head;
    }
}
