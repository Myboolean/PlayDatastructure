package main.heap;

import main.array.Array;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/22
 * Time: 11:30
 *
 * @author:pzj
 */
public class MaxHeap <E extends Comparable<E>>{
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        this(10);
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }
    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回index表示的元素的父元素索引
     * @param index
     * @return
     */
    private int parent(int index){
        return (index - 1) / 2;
    }


    private int leftChild(int index){
        return index * 2 + 1;
    }


    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        shiftUp(size() - 1);
    }


    private void shiftUp(int index){
        while (index > 0) {
            if(data.get(index).compareTo(data.get(parent(index))) > 0) {
//                System.out.println("sift up");
                data.swap(index, parent(index));
                index = parent(index);
            }else {
                break;
            }
        }
    }

    /**
     * 找到堆中最大元素
     * @return
     */
    public E findMax(){
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }
    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax(){
        E max = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()){
//            System.out.println("sift down");
            int i = leftChild(index);
            if(i + 1 < data.getSize() && data.get(i + 1).compareTo(data.get(i)) > 0 ){
                i = rightChild(index);
            }
            //data[i]是左右两个结点的最大值
            if(data.get(index).compareTo(data.get(i)) > 0){
                break;
            }else {
                data.swap(index, i);
                index = i;
            }

        }

    }

    /**
     * 取出最大元素后，放入一个新元素
     * @return
     */
    public E replace(E e){
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }

    /**
     * 把数组整理成堆, 建堆
     *
     * 实现：从最后一个非叶子结点开始siftDown(),可以达成一个堆
     * @param
     */



    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }
}
