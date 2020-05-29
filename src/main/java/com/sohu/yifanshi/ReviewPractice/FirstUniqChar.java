package com.sohu.yifanshi.ReviewPractice;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        firstUniqChar.firstUniqChar("loveleetcode");
    }
    private Node head = new Node();
    private Node tail = new Node();
    public char firstUniqChar(String s) {
        head.next = tail;
        tail.prev = head;
        if(s.length()==1)
            return s.charAt(0);
        HashMap<Character,Node> hashMap = new HashMap();;
        for(int i = 0 ; i < s.length() ; i ++)
        {
            char thisChar = s.charAt(i);
            if(hashMap.containsKey(thisChar))
            {
                Node node =  hashMap.get(thisChar);
                if(node.prev!=null&&node.next!=null)
                {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node.next = null;
                    node.prev = null;
                }
            }else {
                Node tempNode = new Node();
                tempNode.value = thisChar;
                tempNode.prev = tail.prev;
                tempNode.next = tail;
                tail.prev.next = tempNode;
                tail.prev = tempNode;
                hashMap.put(thisChar,tempNode);
            }
        }
        return head.next==tail?' ':head.next.value;
    }
    public class Node{
        Node prev;
        Node next;
        char value;
    }
}
