package main.BST;

import main.stack.ArrayStack;
import main.stack.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/20
 * Time: 17:13
 * 练习：非递归实现
 * @author:pzj
 */
public class BinarySearchTree <E extends Comparable<E>>{
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(E e){
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 递归  ：
     * 需要实现非递归
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if(root == null) {
            return false;
        }
        int compare = e.compareTo(root.e);
        if(compare == 0) {
            return true;
        }else if(compare < 0){
            return contains(root.left,e);
        }else {
            return contains(root.right, e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root){
        if(root == null) {
            return;
        }
        System.out.println(root.e);

        preOrder(root.left);
        preOrder(root.right);
    }

    public E minimum(){
        if(size == 0) {
            throw new IllegalArgumentException("BST is null");
        }
        return minimum(root).e;
    }

    private Node minimum(Node root) {
        if(root.left== null) {
            return root;
        }
        return minimum(root.left);
    }
    public E minimumNR(){
        Node node = root;
        while (node.left!=null) {
            node = node.left;
        }
        return node.e;
    }


    public E maximum(){
        if(size == 0) {
            throw new IllegalArgumentException("BST is null");
        }
        return maximum(root).e;
    }

    private Node maximum(Node root) {
        if(root.right== null) {
            return root;
        }
        return maximum(root.right);
    }

    public E maximumNR(){
        Node node = root;
        while(node.right != null) {
            node = node.right;
        }
        return node.e;
    }
    public E removeMin(){
        E res = minimum();
        root = removeMin(root);
        return res;
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
    public E removeMax(){
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    private Node removeMax(Node node) {
        if(node.right != null) {
            node.right = removeMax(node.right);
            return node;
        } else {
            Node leftNode = node.left;
            node.left =null;
            size--;
            return leftNode;
        }
    }

    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        } else if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
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
    private Node removeUsePre(Node node,  E e ){
        if(node == null) {
            return null;
        } else if(e.compareTo(node.e) < 0){
        node.left = remove(node.left, e);
        return node;
    } else if(e.compareTo(node.e) > 0){
        node.right = remove(node.right, e);
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

        Node leftMax = maximum(node.left);
//                E min = rightMin.e;
        leftMax.left = removeMax(node.left);
        leftMax.right = node.right;
        node.left = node.right = null;
        size--;
        return leftMax;


    }
    }

    public void noDfsPreOrder(){
        Node node = root;
        Stack<Node> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.e);
            if(pop.right != null) {
                stack.push(pop.right);
            }
            if(pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void inOrderNR(){
        Node node = root;
        java.util.Stack<Node> stack = new java.util.Stack<>();
//        stack.push(root);
        while (node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node cur = stack.pop();
                System.out.println(cur.e);
                node = cur.right;
            }
        }

    }
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        System.out.println(node.e);
        postOrder(node.right);
    }
    public void postOrderNR(){
        Node node = root;
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node r = null;
        while (node != null || !stack.isEmpty()) {
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if(node.right != null && node.right != r){
                    node = node.right;
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    System.out.println(node.e);
                    r = node;
                    node = null;
                }
            }
        }
    }

    public void cengxu(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node front = queue.remove();
            System.out.println(front.e);
            if(front.left != null) {
                queue.offer(front.left);
            }
            if(front.right != null) {
                queue.offer(front.right);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node root, int i, StringBuilder res) {
        if(root == null) {
            res.append(generatDepthString(i) + "null\n");
            return;
        }
        res.append(generatDepthString(i) + root.e + "\n");
        generateBSTString(root.left, i + 1, res);
        generateBSTString(root.right, i + 1, res);
    }

    private String generatDepthString(int i) {
        StringBuilder res= new StringBuilder();
        for (int j = 0; j < i; j++) {
            res.append("--");
        }
        return res.toString();
    }
}
