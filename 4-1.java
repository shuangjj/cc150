/*
 * Implement a function to check if a tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
 * from the root by more than one
 *
 */

package cc150.chapter4;
import cc150.ds.tree.*;
import cc150.ds.queue.*;

class Test4_1 {
    static final int midx = 10;
    public static void main(String argv[]) {
        BTree<Integer> btree = new BTree<Integer>();
        MyQueue<TNode<Integer>> mq = new MyQueue<TNode<Integer>>();
        int lidx = 1;

        int ar[] = {-1, 1, 2, -1, 4, 5, 6, 7, 8, 9, 10};
        TNode<Integer> root = btree.createRoot(ar[lidx]);
        mq.enqueue(root);
        lidx++; 
        // Change array list representation of the tree to link representation of binary tree
        while(!mq.isEmpty()) {

            TNode<Integer> v = mq.dequeue();
            if((int)v.getValue()*2 > midx) continue;
            if(ar[lidx] != -1) {
                TNode<Integer> l = btree.insertLeft(v, ar[lidx]);
                mq.enqueue(l);
            }
            lidx++;

            if(((int)v.getValue()*2 + 1) > midx) continue;
            if(ar[lidx] != -1) {
                TNode<Integer> r = btree.insertRight(v, ar[lidx]);
                mq.enqueue(r);
            }
            lidx++;
        }
        // Do Preorder traverse
        btree.preOrderPrint(btree.getRoot());
        System.out.println();

        int max = maxPath(btree.getRoot());
        int min = minPath(btree.getRoot());
        System.out.printf("MAX: %d, MIN %d, balanced: %s\n", max, min, isBalanced(btree.getRoot()) ? "yes" : "no");

    }
    public static int  maxPath(TNode<Integer> root) {
        if(root == null) return -1;
        return Math.max(maxPath(root.getLeft()), maxPath(root.getRight())) + 1;
    }
    public static int minPath(TNode<Integer>  root) {
        if(root == null) return -1;
        return Math.min(minPath(root.getLeft()), minPath(root.getRight())) + 1;
    }
    public static boolean isBalanced(TNode<Integer> root) {
        return (maxPath(root)-minPath(root)) <= 1;
    }

}
