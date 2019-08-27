package com.sohu.yifanshi.test.LRUCache;

import org.junit.Test;

public class test {
    @Test
    public void test1()
    {
        LRUCache lruCache = new LRUCache(10);

        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.put(3,30);
        lruCache.put(4,40);
        lruCache.put(5,50);
        lruCache.put(6,60);

        lruCache.travsal();

        lruCache.put(2,100);
        lruCache.travsal();

        lruCache.del(3);
        lruCache.travsal();

        lruCache.put(3,300);
        lruCache.put(7,700);
        lruCache.put(8,800);
        lruCache.put(9,900);
        lruCache.put(10,1000);
        lruCache.put(1,10);
        lruCache.travsal();



    }
}
