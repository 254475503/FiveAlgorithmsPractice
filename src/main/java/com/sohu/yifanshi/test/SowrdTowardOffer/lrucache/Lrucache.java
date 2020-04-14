package com.sohu.yifanshi.test.SowrdTowardOffer.lrucache;

/*
*使用链表实现一个lruchache。淘汰最近未使用的缓存
 *  */
//链表总结，1 烧饼，2 仔细分析链表长度为1，长度为2这种特殊情况时的操作。
public class Lrucache {

    private int size;
    private int count = 0 ;
    private LinkedList mycache;
    Lrucache(int size)
    {
        this.size = size;
    }

    private class LinkedList{
        LinkedList()
        {

        }
        private int value;
        public LinkedList next;
        public int getValue(){
            return this.value;
        }
        public void setValue(int value){
            this.value = value;
        }
    }

    public void put (int value)
    {
        LinkedList p = isExistGuard(value);
        if(p==null)
        {
            if(count==size)
                out();
            else
                count++;
            LinkedList newnode = new LinkedList();
            newnode.setValue(value);
            newnode.next = mycache;
            mycache = newnode;
        }
    }

    private void out()//淘汰，不是remove。淘汰只供缓存满了之后，淘汰末尾的最近未使用的节点。
    {
        if(size==1)
            mycache = null;
        else if(size==2)
            mycache.next = null;
        else if(size>2)
        {
            LinkedList p = mycache;
            while (p.next.next!=null)
                p = p.next;
            p.next = null;
        }
    }
    public LinkedList isExist(int value)//非烧饼模式
    {
        LinkedList p = this.mycache;
        while (p!=null)//烧饼主要是能减少循环中这一次的比较。但是哨兵貌似更加适合双向链表与数组。单项链表会多一次循环。
        {
            if(p.getValue()==value)
                return p;
            p = p.next;
        }
        return null;
    }

    public LinkedList isExistGuard(int value)//烧饼模式
    {//所谓哨兵模式的查找就是将查找值替换头或者尾节点。这里替换了尾节点。这样能减少去比较p!=null的次数
        //若在循环的过程中遍历到与尾节点的值也就是目标值相等的节点，那么就存在，不然一直遍历到p,q节点重合，
        //那么就不存在。
       LinkedList p = this.mycache;
       while (p.next!=null)
           p = p.next;//p节点遍历到为节点
       if(p.getValue()==value)
           return p;//若尾节点的值等于目标值直接返回
       int temp = p.getValue();//不然就替换
       p.setValue(value);
       LinkedList q = this.mycache;//用q指针再次循环。一直遍历到q与p的值相等
       while (q.getValue()!=value)
           q = q.next;
       p.value = temp;
       if(!q.equals(p))//若q与p指向的对象不是一个，说明链表中存在。
       {
           if(!mycache.equals(q))//访问了一次就将这个缓存放到队头。
           {
               LinkedList m = mycache;
               while (!m.next.equals(q))
                   m = m.next;
               m.next = q.next;
               q.next = mycache;
               mycache = q;
           }
           return q;
       }
       else
           return null;
    }

}
