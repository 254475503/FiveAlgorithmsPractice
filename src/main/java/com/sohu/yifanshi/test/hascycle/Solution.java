package com.sohu.yifanshi.test.hascycle;

import com.sohu.yifanshi.test.reverseList.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast!=null)
        {
            fast = fast.next;
            if(fast==null)
                return false;
            fast = fast.next;
            slow = slow.next;
            if(slow==fast&&fast!=null)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        one.next.next = three;
        Solution solution = new Solution();
        ListNode newhead = solution.reverseListNode(one);
        while (newhead!=null)
        {
            System.out.println(newhead.val);
            newhead = newhead.next;
        }
    }
    public ListNode reverseListNode(ListNode head)
    {
        if(head.next == null)
            return head;
        if(head.next.next ==null)
        {
            ListNode newhead = head.next;
            head.next.next = head;
            head.next = null;
            return newhead;
        }
        ListNode tail = head,newhead = head,next = head.next;

        while(next != null)
        {
            tail.next = next.next;
            next.next = newhead;
            newhead = next;
            next = tail.next;
        }
        return newhead;
    }
}
