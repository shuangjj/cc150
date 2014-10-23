/*
 * Implement binary tree
 */
package cc150.ds.tree;
import cc150.ds.queue.*;
public class BTree<E> {
    TNode<E> root;
    int size;
    public BTree() {
        root = null;
        size = 0;
    }
    public TNode<E> getRoot() {
        return root;
    } 
    public TNode<E> createRoot(E e) {
        if(root != null) return root;

        root = new TNode<E>(e);
        size++;
        return root;
    }

    public TNode<E> insertLeft(TNode<E> n, E l) {
        TNode<E> newNode = new TNode<E>(l);
        n.left = newNode;
        newNode.parent = n;
        size++;
        return newNode;
    }

    public TNode<E> insertRight(TNode<E> n, E r) {
        TNode<E> newNode = new TNode<E>(r);
        n.right = newNode;
        newNode.parent = n;
        size++;
        return newNode;
    }
    /*
    public TNode<E> getLeft(TNode<E> v) {
        return  v.left;
    }
    public TNode<E> getRight(TNode<E> v) {
        return v.right;
    }
    */
    public boolean hasLeft(TNode<E> n) {
        return n.left != null;
    }
    public boolean hasRight(TNode<E> n) {
        return n.right != null;
    }
    public void preOrderPrint(TNode<E> root) {
        if(root == null) return; 
        System.out.printf("%d ", root.getValue());
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }
}
/*
class TNode<E> {
    E value;
    TNode<E> parent;
    TNode<E> left;
    TNode<E> right;
    public TNode(E v) {
        this.value = v;
        parent = null;
        left = null;
        right = null;
    }
    public E getValue() {
        return value;
    }
}
*/
