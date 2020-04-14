package com.sohu.yifanshi.test.loopqueue;

public class Loopqueue {//循环队列，循环队列解决的是用数组实现的队列要
    //出队时需要进行大辆的数据搬运问题。但是循环队列会浪费一个尾节点，不能装东西。
    private int[] queueContainer;
    private int head;
    private int tail;
    public Loopqueue(int size)
    {
        queueContainer =new int[size];
        head=0;
        tail=0;
    }
    public void enqueue(int data)
    {
        if((tail+1)%queueContainer.length==head)
        {
            System.out.println("循环队列已满");
        }else {
            queueContainer[tail] = data;
            tail=(tail+1)%queueContainer.length;
        }

    }
    public int dequeue()
    {
        if(head==tail)
        {
            System.out.println("循环队列为空");
            return 0;
        }else {
           int result = queueContainer[head];
           head = (head+1)%queueContainer.length;
           return result;
        }
    }

}
