package com.sohu.yifanshi.test.listNodeSort;

import org.junit.Test;

public class test {
    @Test
    public void testMergeSort()
    {
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        MergeSort mergeSort = new MergeSort();

        ListNode p = mergeSort.mergeSort(head);
        while (p!=null)
        {
            System.out.println(p.val);
            p=p.next;
        }
    }
}
