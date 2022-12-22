package main.setandmap;

public interface Map <K, V>{
    int getSize();
    void add(K key, V value);
    V remove(K key);
    V get(K key);
    void set(K key, V value);
    boolean contains(K key);
    boolean isEmpty();
}
