package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.reverseList.ListNode;

public class ReverseListNode {
    public static ListNode reversList(ListNode headNode){
        ListNode nextNode = headNode.next;
        if(nextNode==null)
            return headNode;
        ListNode tailNode = headNode;
        while (nextNode!=null)
        {
            headNode.next = nextNode.next;
            nextNode.next = tailNode;
            tailNode  = nextNode;
            nextNode = headNode.next;
        }
        return tailNode;//最后尾节点就是反转后的头节点
    }

    public static void main(String[] args) {
        int[] result = new int[1];
        ListNode newNode = new ListNode(0);
        newNode.next = new ListNode(1);
        newNode.next.next = new ListNode(2);
        newNode.next.next.next = new ListNode(3);
        ListNode newList = reversList(newNode);
        while (newList!=null)
        {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
}
