package main.array;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/18
 * Time: 15:37
 *
 * @author:pzj
 */
public class Array<E> {
    private E[] data;

    /**
     * 有效元素个数
     */
    private int size;

    /**
     * 构造函数， 传入数组的容量capacity构造Array
     * @param capacity 容量大小
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(){
        // 不传的时候默认长度
        this(10);
    }

    /**
     * 用户传入静态数组，我们用来生成动态数组
     * @param data
     */
    public Array(E [] data) {
        this.data = (E[])new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        size = this.data.length;

    }

    /**
     * 添加元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组头部插入数据
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }
    /**
     * 在指定位置index插入元素e
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if(size == capacity()) {
            resize(2 * capacity());
        }

        if(index >= capacity() || index < 0){
            throw new IllegalArgumentException("add Failed, index out of Array length");
        }
        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }


    /**
     * 自动扩容
     */
    public void resize(int length){
        E[] newData = (E[])new Object[length];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }
    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if(index >= size || index < 0){
            throw new IllegalArgumentException("add Failed, index out of Array length");
        }
        return data[index];
    }
    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if(index >= size || index < 0){
            throw new IllegalArgumentException("add Failed, index out of Array length");
        }
        data[index] = e;
    }
    /**
     * 获取数组的容量
     * @return
     */
    public int capacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 寻找元素e的索引,如果不存在元素e， 则返回元素-1，找到第一个相等的元素
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 找到所有的 e
     * @param e
     * @return
     */
    public Array findAll(E e) {
        Array<Integer> array = new Array();
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                array.addLast(i);
            }
        }
        return array;
    }
    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("indexo ut of");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    /**
     * 从数组中删除元素,返回删除的元素
     * @param index
     * @return 删除的元素
     */
    public E remove(int index) {
        if(index >= size || index < 0){
            throw new IllegalArgumentException("add Failed, index out of Array length");
        }

        if(size <= capacity() / 4) {
            resize(capacity() / 2);
        }

        E r = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size -- ;
        data[size] = null;

        return r;
    }

    /**
     * 删除最后一个元素
     * @return 返回删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中第一个元素
     * @return 返回删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除元素e，只能删除第一个
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);

        if(index != -1) {
            remove(index);
        }
    }

    /**
     * 删除数组中所有的元素e
     * @param e
     */
    public void removeAllElement(E e) {
        Array array = findAll(e);
        for (int i = 0; i < array.getSize(); i++) {
            remove((Integer) array.get(i));
        }
    }

    /**
     * 打印格式
     * @return
     */
    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ",capacity" + capacity()+
                '}';
    }
}
