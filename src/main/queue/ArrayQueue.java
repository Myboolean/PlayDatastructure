package main.queue;

import main.array.Array;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/19
 * Time: 10:42
 *
 * @author:pzj
 */
public class ArrayQueue<E> implements Queue<E>{
    private Array<E> array;
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
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

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E front() {
        return array.getFirst();
    }

    @Override
    public E pop() {
        return array.removeFirst();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + array +
                '}';
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
    }
}
