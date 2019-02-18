package com.sohu.yifanshi.test.listNodeSort;

public class MergeSort {
    //这是链表的归并排序。时间复杂度为nlogn 空间复杂度不算递归空间的话为O(1)常数级。应该是链表排序的最优解。

    public ListNode mergeSort(ListNode list)//这是将链表分裂的函数。
    {
        if(list==null||list.next==null)//递归界。
            return list;
        else {
            ListNode fast = list;
            ListNode low  = list;

            while(fast.next!=null&&fast.next.next!=null)//两个指针，fast一次跳两个项，low一次跳一个项。这样到最后，low一定位于链表中间。
            {
                fast=fast.next.next;
                low = low.next;
            }
            fast = low.next;//fast到low的next作为后半部分的链表头
            low.next = null;//low的next指针空置，将前半部分链表独立，原链表头为链表头。
            low = mergeSort(list);//递归进行
            fast= mergeSort(fast);//递归进行
            return merge(fast,low);//合并
        }


    }

    public ListNode merge(ListNode fast,ListNode low)
    {
        if(fast==null)//出现fast或low有一项为空，直接返回另一项
            return low;
        if(low==null)
            return fast;
        ListNode res = new ListNode();//用于返回的链表头
        ListNode p = new ListNode();//进行添加的指针
        if(fast.val<low.val)//选出两个链表中链表头小的那一项
        {
            res = fast;
            fast = fast.next;
        }else
        {
            res = low;
            low = low.next;
        }
        p = res;
        while(fast!=null&&low!=null)//谁小谁就添加到p.next后面，直到其中一个链表为空。
        {
            if(fast.val<low.val)
            {
                p.next = fast;
                fast = fast.next;
            }else
            {
                p.next = low;
                low = low.next;
            }
            p = p.next;
        }
        if(fast!=null)//其中一个链表为空直接将另一个链表的表头接到p.next
            p.next = fast;
        else if(low!=null)
            p.next = low;
        return res;
    }
}
