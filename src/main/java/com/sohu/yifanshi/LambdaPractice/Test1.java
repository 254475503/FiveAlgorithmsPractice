package com.sohu.yifanshi.LambdaPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test1 {
    private List<Integer> integers = new ArrayList<>();
    Test1()
    {
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integerIterator = integers.iterator();
    }
    Iterator<Integer> integerIterator;
    public void execution()
    {
        while (integerIterator.hasNext())
        {
            System.out.println(integerIterator.next());
            execution();
        }
    }

    public void test(Consumer consumer)
    {
        consumer.accept(null);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.execution();

        Function<Integer,Integer> func1 = (x)-> x+1;

        Function<Integer,Integer> func2 = (x)-> x*x+1;

        System.out.println(func1.compose(func2).apply(3));
        Consumer consumer1 = x->{
            System.out.println(x);
        };

        Consumer consumer2 = System.out::println;
        consumer1.accept("asd");
        consumer2.accept("aaa");
    }


}
