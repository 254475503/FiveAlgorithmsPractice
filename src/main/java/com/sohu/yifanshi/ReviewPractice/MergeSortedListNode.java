package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.reverseList.ListNode;

public class MergeSortedListNode {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        if(l1==null&&l2!=null)
            return l2;
        if(l1!=null&&l2==null)
            return l1;
        ListNode a,b = null;
        if(l1.val<=l2.val)
        {
            b = a = l1;
            l1 = l1.next;
            a.next = null;
        }else {
            b = a = l2;
            l2 = l2.next;
            a.next = null;
        }
        ListNode p = l1;
        ListNode q = l2;
        while (p!=null&&q!=null)
        {
            if(p.val<=q.val)
            {
                a.next = p;
                a = p;
                p = p.next;
                a.next=null;
            }else {
                a.next = q;
                a = q;
                q = q.next;
                a.next=null;
            }
        }
        if(p!=null)
        {
            a.next = p;
        }
        if(q!=null)
        {
            a.next = q;
        }
        return b;
    }
}
