package main.setandmap;

public interface Set <E>{

    int getSize();
    void add(E e);
    void remove(E e);
    boolean isEmpty();
    boolean contains(E e);
}
