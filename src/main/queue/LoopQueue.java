package main.queue;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/19
 * Time: 10:59
 *
 * @author:pzj
 */
public class LoopQueue <E> implements Queue<E>{
    private E[] data;
    int front;
    int tail;
    int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        size = 0 ;
        front = 0;
        tail = 0;
    }
    public LoopQueue(){
        this(10);
    }

    /**
     * 有一个单位用来作为队列满的判断
     * @return
     */
    public int getCapacity(){
        return data.length -1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
    public boolean isFull(){
        return (tail + 1) % data.length == front;
    }

    @Override
    public void push(E e) {
        if(isFull()) {
            resize(getCapacity() * 2 );
        }
        data[tail]  = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData =(E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data =newData;
        front = 0;
        tail = size;
    }

    @Override
    public E front() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot pop from empty queue");
        }
        return data[front];
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot pop from empty queue");
        }
        if(size < getCapacity() / 4 && getCapacity() /2 != 0) {
            resize(getCapacity() / 2);
        }
        E ret = data[front];
        data[front] = null;
        front++;
        size--;
        return ret;
    }


    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.push(i);
        }
        System.out.println(queue);
        System.out.println(queue.front());
        for (int i = 0; i < 17; i++) {
            System.out.println(queue.pop());
        }
        System.out.println(queue);
    }
}
