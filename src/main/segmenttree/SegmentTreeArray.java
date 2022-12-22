package main.segmenttree;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/22
 * Time: 21:26
 *
 * @author:pzj
 */


public class SegmentTreeArray <E>{
    private E[] data;
    private E[] tree;
    public SegmentTreeArray(E [] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        // 4n 可以存储下一棵线段树
        tree = (E[]) new Object[data.length * 4];

    }
    public int size(){
        return data.length;
    }
    public E get(int index){
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

}
