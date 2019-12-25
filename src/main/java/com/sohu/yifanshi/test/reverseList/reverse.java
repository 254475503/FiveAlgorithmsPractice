package com.sohu.yifanshi.test.reverseList;

public class reverse {
    public ListNode reverseList(ListNode head)
    {
        ListNode temp = head , pcur = head.next;

        while(pcur!=null)
        {
            head.next = pcur.next;
            pcur.next = temp;
            temp = pcur;
            pcur = head.next;
        }
        return temp;
    }

    public ListNode diguiReverseList(ListNode head)
    {
        if(head.next == null)
            return head;
        else {
            ListNode last = diguiReverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
}
