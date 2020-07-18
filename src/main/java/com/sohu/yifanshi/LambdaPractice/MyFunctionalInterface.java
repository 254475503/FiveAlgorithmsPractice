package com.sohu.yifanshi.LambdaPractice;

@FunctionalInterface
public interface MyFunctionalInterface<T,R> {
    R test(T t);

    default <T> MyFunctionalInterface<T,T> idetify(T t)
    {
        return (o)->  o;
    }

}
