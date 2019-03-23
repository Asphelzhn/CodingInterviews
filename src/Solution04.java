

import java.util.ArrayList;
import java.util.Collections;

public class Solution04 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(6);
        listNode.next = listNode2;

        ArrayList<Integer> array = new Solution04().printListFromTailToHead(listNode);
        for (Integer i:array) {
            System.out.println(i+",");
        }
    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        if(listNode==null){
            return array;
        }
        while (listNode != null){
            int val = listNode.val;
            array.add(val);
            listNode = listNode.next;
        }
        Collections.reverse(array);
        return array;
    }
}
