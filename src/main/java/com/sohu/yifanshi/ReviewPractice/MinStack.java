package com.sohu.yifanshi.ReviewPractice;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack ;
    //LinkedList
    public MinStack() {
        mainStack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        mainStack.push(x);
        if(minStack.size()==0||x<minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        int min = minStack.peek();
        if(mainStack.peek() == min){
            minStack.pop();
        }
        mainStack.pop();

    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
