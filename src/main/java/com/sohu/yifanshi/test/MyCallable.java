package com.sohu.yifanshi.test;

import org.junit.Test;

import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 1;
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyCallable myCallable = new MyCallable();
        Future<Integer> future = executorService.submit(myCallable);
        Integer sadas = future.get();
        System.out.println(sadas);
    }
}
