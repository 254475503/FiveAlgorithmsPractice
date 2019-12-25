package com.sohu.yifanshi.test.reverseList;

public class Test {
    @org.junit.Test
    public  void  test()
    {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        reverse reverse = new reverse();
        ListNode temp = reverse.diguiReverseList(list1);
        while (temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }


    }
}
