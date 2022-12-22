package main.setandmap;

import main.linkedlist.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/21
 * Time: 20:03
 *
 * @author:pzj
 */
public class LinkeListMap <K, V> implements Map<K, V>{
    class Node {
        public K key;
        public V value;
        public Node next;
        public Node(K key ) {
            this(key, null, null);
        }

        public Node(K key, V val, Node next) {
            this.value = val;
            this.key = key;
            this.next = next;
        }
        public Node(){
            this(null, null, null);
        }
    }
    public LinkeListMap(){
        dummyHead = new Node();
        size = 0;
    }
    private Node dummyHead;
    private int size;
    @Override
    public int getSize() {
        return size;
    }

    public Node getNode(K key) {
        Node node =  dummyHead.next;
        while (node != null) {
            if (node.key.equals(key)){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else {
            node.value = value;
        }
    }


    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        Node cur = dummyHead.next;
        while (cur != null && cur.key != key) {
            pre = pre.next;
            cur = cur.next;
        }
        if(cur != null) {
            pre.next = cur.next;
            cur.next = null;
            size--;
            return cur.value;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return  node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "dosen't exsit!");
        }else {
            node.value = value;
        }
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(key);
        if (node == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
