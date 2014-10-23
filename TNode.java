package cc150.ds.tree;
public class TNode<E> {
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
    public TNode<E> getLeft() {
        return  left;
    }
    public TNode<E> getRight() {
        return right;
    }
 
}
