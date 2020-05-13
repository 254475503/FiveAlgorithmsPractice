package com.sohu.yifanshi.ReviewPractice;

import java.util.HashMap;

public class CopyComplexListNode {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {//hash表的方法
        if (head == null)
            return null;
        Node p = head;
        Node pphead = null;
        Node pp = null;
        pp = pphead = new Node(p.val);

        HashMap<Node, Node> tempMap = new HashMap<>();
        tempMap.put(p, pp);
        while (p.next != null) {
            pp.next = new Node(p.next.val);
            tempMap.put(p.next, pp.next);
            pp = pp.next;
            p = p.next;
        }
        p = head;
        pp = pphead;
        while (p != null) {
            if (p.random != null)
                pp.random = tempMap.get(p.random);
            else
                pp.random = null;
            p = p.next;
            pp = pp.next;
        }
        return pphead;
    }

    public Node copyRandomListSolution2(Node head) {//每个节点后面都复制一个一样的节点。想象一下就能出来了
        if (head == null)
            return null;
        Node p = head;
        while (p != null) {
            Node pp = new Node(p.val);
            pp.next = p.next;
            p.next = pp;
            p = pp.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            else
                p.next.random = null;
            p = p.next.next;
        }
        p = head;
        Node pp = p.next;
        Node pphead = pp;
        while (pp.next != null) {
            p.next = pp.next;
            p = pp.next;
            pp.next = p.next;
            pp = p.next;
        }
        p.next = null;
        return pphead;

    }
}
