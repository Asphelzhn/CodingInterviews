/*
* 题目描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

思路：
从头遍历链表，添加到ArrayList中，然后通过Collections类反转列表元素即可
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution03 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(6);
        listNode.next = listNode2;

        ArrayList<Integer> array = new Solution03().printListFromTailToHead(listNode);
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
