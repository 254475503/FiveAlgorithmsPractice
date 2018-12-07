package com.sohu.yifanshi.test.addTwoNumber;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        ListNode returnNode = addTwoNumbers(l1,l2);
        while(returnNode!=null)
        {
            System.out.println(returnNode.val);
            returnNode = returnNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        * ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y; 两个链表的值加上上一次的进位值
        carry = sum / 10; carry为进位的值。记录下来留到下一次使用
        curr.next = new ListNode(sum % 10); 此位的值。
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
        * */
        //以上是参考代码。通过观察两者的代码发现，并总结，如果是对链表的数据进行操作。应该先再链表外部将数据操作完，再将数据加入链表。而不是像我一样
        //通过数据的不同变化和其他各种情况的分支来控制链表的增长。这道题中，有值就增长链表，没有值就不增长，就是这么简单，被我写的太麻烦了。。
        //主要是因为我把进位的操作放在了链表中。这样就略显累赘了。而上面的算法将进位数记录下来，放在下一次循环中去计算。这样就省去了我的再这一步就要进行
        //进位扩容判断且对下一位提前进行计算。

        ListNode returnNode = new ListNode(0);
        ListNode pointer = returnNode;
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        while(!(l1Pointer==null&&l2Pointer==null))
        {
            if(l1Pointer!=null&&l2Pointer!=null)
            {
                if(!((pointer.val+=(l1Pointer.val+l2Pointer.val))<10))
                {
                    if(pointer.next==null)
                    {
                        pointer.next = new ListNode(0);
                    }
                    pointer.val -= 10;
                    pointer.next.val += 1;
                }
                if((l1Pointer.next!=null || l2Pointer.next !=null) && pointer.next==null)
                    pointer.next = new ListNode(0);
            }
            else {
                if(l1Pointer==null)
                {
                    if(!((pointer.val += l2Pointer.val)<10))
                    {
                        if(pointer.next==null)
                        {
                            pointer.next = new ListNode(0);
                        }
                        pointer.val -= 10;
                        pointer.next.val += 1;
                    }
                    if(l2Pointer.next!=null && pointer.next == null)
                        pointer.next = new ListNode(0);
                }
                else{
                    if(!((pointer.val += l1Pointer.val)<10))
                    {
                        if(pointer.next==null)
                        {
                            pointer.next = new ListNode(0);
                        }
                        pointer.val -= 10;
                        pointer.next.val += 1;
                    }
                    if(l1Pointer.next != null && pointer.next == null)
                        pointer.next = new ListNode(0);
                }
            }

            pointer = pointer.next;
            if(l1Pointer!=null)
                l1Pointer = l1Pointer.next;
            if(l2Pointer!=null)
                l2Pointer = l2Pointer.next;
        }


        return returnNode;
    }
}
