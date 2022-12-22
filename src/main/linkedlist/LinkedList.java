package main.linkedlist;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/19
 * Time: 15:02
 *
 * @author:pzj
 */
public class LinkedList<E> {
    private class Node {
        public E val;
        public Node next;

        public Node(E val) {
            this(val, null);
        }

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }
        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0, e);
    }

    public void add(int index ,E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add Failed, Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        prev.next= new Node(e, prev.next);
        size++;

    }

    public void addLast(E e){
        add(size, e);
    }

    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add Failed, Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add Failed, Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.val = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.val.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove Failed, Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;
        return del.val;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        Node pre = dummyHead;
        Node cur = dummyHead.next;
        while (cur != null && cur.val != e) {
            pre = pre.next;
            cur = cur.next;
        }
        if(cur != null) {
            pre.next = cur.next;
            cur.next = null;
            cur = null;
            size--;
        }

    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList{" );
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {

            res.append(cur.val);
            if(i != size - 1) {
                res.append(", ");
            }
            cur = cur.next;
        }
        res.append("}  size  "  +size);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        System.out.println(list);
        list.add(1,5);

        System.out.println(list);
        list.set(1, 8);
        System.out.println(list);
        System.out.println(list.remove(2));
        System.out.println(list);
    }
}
