package main.setandmap;

import main.BST.BinarySearchTree;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/21
 * Time: 20:24
 *
 * @author:pzj
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K,V>{

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }


    }
    private Node root;
    private int size;
    public BSTMap(){
        root = null;
        size = 0;
    }
    @Override

    public int getSize() {
        return size;
    }


    private Node add(Node node, K key, V value) {
        if(node == null) {
            size++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }
    private Node getNode(Node node , K key) {
        if(node == null) {
            return null;
        } else if(key.compareTo(node.key) == 0){
            return node;
        } else if(key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    private Node minimum(Node root) {
        if(root.left== null) {
            return root;
        }
        return minimum(root.left);
    }
    private Node removeMin(Node node) {
        if(node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
    }
    private Node remove(Node node, K key) {
        if(node == null) {
            return null;
        } else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        } else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        } else {
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null) {
                Node leftNode = node.left;
                node.left =null;
                size--;
                return leftNode;
            }

            Node rightMin = minimum(node.right);
//                E min = rightMin.e;
            rightMin.left = node.left;
            rightMin.right = removeMin(node.right);
            node.left = node.right = null;
            size--;
            return rightMin;


        }

    }
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + "dosent exsit");
        }
        node.value = value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
