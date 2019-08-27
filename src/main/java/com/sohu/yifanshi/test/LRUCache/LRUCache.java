package com.sohu.yifanshi.test.LRUCache;


import java.util.HashMap;

public class LRUCache {/*时间复杂度为O(1)的lrucache（最近最不常使用的就淘汰）使用双向链表和map进行实现*/
    private int size = 0;
    private int capacity;
    private HashMap<Integer,Node> cacheMap ;
    public Node head = new Node(-1,-1);
    public Node tail = new Node(-1,-1);
    LRUCache(int capacity)
    {
        cacheMap = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key,int value)
    {
        Node node = new Node(key,value);
        Node existNode = cacheMap.get(key);
        if(size<capacity)
        {
            if(existNode!=null)
            {
                existNode.setValue(value);
                insertHead(removeFromList(existNode));
                size++;
            }
            else{
                insertHead(node);
                cacheMap.put(node.getKey(),node);
            }

        }else {
            if(existNode!=null)
            {
                existNode.setValue(value);
                insertHead(removeFromList(existNode));
            }else {
                LRUdel();
                insertHead(node);
                cacheMap.put(node.getKey(),node);
            }


        }
    }
    public void insertHead(Node node)
    {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public Node removeFromList(Node node)
    {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
        return node;
    }
    public Node del(int key)
    {
        Node node = cacheMap.get(key);
        if(node!=null) {

            removeFromList(node);
            cacheMap.remove(node.getKey());
            size--;
        }
        return  node;
    }

    public void travsal()
    {
        Node node = head.next;
        while(!node.equals(tail))
        {
            System.out.print(node.key+":"+node.value+" ");
            node = node.next;
        }
        System.out.println();
    }
    public Node get(int key)
    {
        Node node = cacheMap.get(key);
        if(node!=null)
        {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        return node;
    }



    public Node LRUdel()
    {
        Node returnNode = tail.prev;
        removeFromList(returnNode);
        cacheMap.remove(returnNode.getKey());
        return  returnNode;
    }



   class Node{
       private int key;
       private int value;
       public Node prev;
       public Node next;
       Node(int key,int value)
       {
           this.key = key;
           this.value = value;
       }

       public int getKey() {
           return key;
       }

       public void setKey(int key) {
           this.key = key;
       }

       public int getValue() {
           return value;
       }

       public void setValue(int value) {
           this.value = value;
       }

       public Node getPrev() {
           return prev;
       }

       public void setPrev(Node prev) {
           this.prev = prev;
       }

       public Node getNext() {
           return next;
       }

       public void setNext(Node next) {
           this.next = next;
       }
   }


}
