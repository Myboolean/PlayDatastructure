package main.setandmap;

import main.linkedlist.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/21
 * Time: 17:24
 *
 * @author:pzj
 */
public class LinkedListSet<E> implements Set<E>{
    private LinkedList<E> list ;
    public LinkedListSet(){
        list = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public String toString() {
        return "LinkedListSet{" +
                "list=" + list +
                '}';
    }
}
