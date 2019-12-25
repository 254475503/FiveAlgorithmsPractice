package com.sohu.yifanshi.test.mergeKLists;

import com.sohu.yifanshi.test.reverseList.ListNode;
import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    @Test
    public void test()
    {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);
        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);
        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);
        listNodes = new ListNode[0];
        mergeKLists(listNodes);
    }
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists==null||lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        ArrayList<ListNode> newlists = new ArrayList<ListNode>(lists.length);
        for(ListNode node : lists)
        {
            if(node!=null)
                newlists.add(node);
        }
        while (newlists.size()!=1)
        {
            for(int i = 0 ;i<newlists.size();i++)
            {
                if(i!=newlists.size()-1)
                    merge(newlists,i,i+1);
            }
        }
        return newlists.get(0);
    }

    public void merge(ArrayList<ListNode> lists,int a, int b)
    {
        ListNode A = lists.get(a);
        ListNode B = lists.get(b);
        ListNode temp,head;
        if(A.val<B.val)
        {
            head = temp = new ListNode(A.val);
            A = A.next;
        }
        else
        {
            head = temp = new ListNode(B.val);
            B = B.next;
        }
        while (A!=null&&B!=null)
        {
            if(A.val<B.val)
            {
                temp.next = A;
                A = A.next;
            }
            else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }

        if(A!=null)
        {
            temp.next = A;
        }else if(B!=null)
        {
            temp.next = B;
        }
        lists.set(a,head);
        lists.remove(b);
    }
}
