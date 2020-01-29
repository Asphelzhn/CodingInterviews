import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * <p>
 * 1. 使用递归
 * 要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，最后再打印第一个节点 1。而链表 2->3 可以看成一个新的链表，要逆序打印该链表可以继续使用求解函数，也就是在求解函数中调用自己，这就是递归函数。
 * <p>
 * 2. 使用头插法
 * 头插法顾名思义是将节点插入到头部：在遍历原始链表时，将当前节点插入新链表的头部，使其成为第一个节点。
 * <p>
 * 链表的操作需要维护后继关系，例如在某个节点 node1 之后插入一个节点 node2，我们可以通过修改后继关系来实现：
 * <p>
 * 3. 使用栈
 * 栈具有后进先出的特点，在遍历链表时将值按顺序放入栈中，最后出栈的顺序即为逆序。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseListNode_Problem03 {

    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode head = new ListNode(-1);
        head.next = null;
        while (listNode != null) {
            ListNode temp = new ListNode(listNode.val);
            temp.next = head.next;
            head.next = temp;
            listNode = listNode.next;
        }
        head = head.next;

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            list.add(pop);
        }
        return list;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        ArrayList<Integer> array = printListFromTailToHead3(listNode);
        System.out.println(array);


    }

}
