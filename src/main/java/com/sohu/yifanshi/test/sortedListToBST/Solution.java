package com.sohu.yifanshi.test.sortedListToBST;

import com.sohu.yifanshi.test.addTwoNumber.ListNode;
import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        node1.next = node2;
        solution.sortedListToBST(node1);
    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while(head!=null)
        {
            list.add(head.val);
            head = head.next;
        }
        return recur(0,list.size()-1,list);
    }
    public TreeNode recur(int low,int high,List<Integer> list)
    {
        if(low<high||low<0||high>(list.size()-1))
            return null;
        if(low==high)
            return new TreeNode(list.get(low));
        int mid = (low+high)/2;
        TreeNode thisNode = new TreeNode(list.get(mid));
        thisNode.left = recur(low,mid-1,list);
        thisNode.right = recur(mid+1,high,list);
        return thisNode;
    }
}
