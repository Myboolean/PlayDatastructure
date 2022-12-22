package main.stack;

import main.array.Array;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/19
 * Time: 9:56
 *
 * @author:pzj
 */
public class ArrayStack<E> implements Stack<E>{
    Array<E> array;
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int capacity(){
        return array.capacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 返回最近的元素
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(getSize() - 1);
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}
