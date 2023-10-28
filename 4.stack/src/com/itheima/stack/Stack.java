package com.itheima.stack;

public interface Stack<E> { //栈接口
    boolean push(E value);
    //向栈顶压入元素
    //Params:value-待压入值
    //Returns:压入成功返回true,否则返回false
    E pop();
    //从栈顶弹出元素；Returns:栈非空返回栈顶元素，栈为空返回null
    E peek();
    //返回栈顶元素，不弹出；Returns:栈非空返回栈顶元素，栈为空返回null
    boolean isEmpty();
    //判断栈是否为空；Retruns:空返回true,否则返回false
    boolean isFull();
    //判断栈是否已满；Retruns:满返回true,否则返回false
}
