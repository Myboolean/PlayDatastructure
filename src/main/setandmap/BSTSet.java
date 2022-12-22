package main.setandmap;

import main.BST.BinarySearchTree;
import main.setandmap.Set;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/20
 * Time: 17:22
 *
 * @author:pzj
 */
public class BSTSet <E extends  Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BSTSet(){
        bst = new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
}
