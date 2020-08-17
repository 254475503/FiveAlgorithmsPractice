package com.sohu.yifanshi.test.cloneGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class SOlution {
    public static void main(String[] args) {
        SOlution sOlution = new SOlution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        sOlution.cloneGraph(node1);

    }
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Queue<Node> bfsqueue = new LinkedBlockingQueue<>();

        HashMap<Node,Node> map = new HashMap<>();
        bfsqueue.add(node);
        Node result = new Node(node.val);
        map.put(node,result);
        while (bfsqueue.size()!=0)
        {
            Node thisnode = bfsqueue.poll();
            thisnode.neighbors.stream().forEach(a->{
               if(!map.containsKey(thisnode))
               {
                   map.put(a,new Node(a.val));
                   bfsqueue.add(a);
               }
               map.get(thisnode).neighbors.add(map.get(a));
            });
        }
        return result;

    }
}
