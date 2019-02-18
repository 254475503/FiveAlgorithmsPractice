package com.sohu.yifanshi.test.deleteDuplicate;

import com.sohu.yifanshi.test.addTwoNumber.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);
        l1 = deleteDuplicates(l1);
        while(l1!=null)
        {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {//删除有序链表中的重复部分。我将删除分为两种情况。第一种是需要保存前面节点的删除。
        //如链表123334455，这样的链表需要输出12，也就是前面需要保留一部分。还有一种是前面没有保留的链表，如链表112233445只需要输出5.这两种删除
        //的删除方式并不相同。所以我将这两种情况分开讨论。有保留的需要操作保留的最后一位节点的next指针将其指向后面非重复的部分。而无保留的删除
        //则需要移动链表本身的头节点，将头节点移动到后面非重复的部分。下面的第一个while对应不保留删除。第二个while对应保留删除。
        ListNode pointer = head;
        while (pointer!=null&&pointer.next!=null&&pointer.val==pointer.next.val) {
            ListNode tail = pointer.next;
            while (tail!=null&&tail.val==pointer.val)
            {
                tail = tail.next;
            }
            pointer = head = tail;
        }
        while(pointer!=null&&pointer.next!=null&&pointer.next.next!=null)
        {
            if(pointer.next.val!=pointer.next.next.val)
                pointer = pointer.next;
            else
            {
                ListNode tail = pointer.next;
                while (tail.next!=null)
                {
                    if(tail.val!=tail.next.val)
                        break;
                    else
                        tail.next = tail.next.next;
                }
                pointer.next = tail.next;
            }
        }
        return head;
    }
}
