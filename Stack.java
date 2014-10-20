package cc150.ds.stack;

class Node {
    int data;
    int curmin;
    Node next;
    public Node(int val) {
        data = val;
        next = null;
        curmin = Integer.MAX_VALUE;
    }
}

public class Stack {
    Node top;
    int min;
    public Stack next;
    int cap;

    public Stack() {
        cap = 0;
        top = null;
        next = null;
    }

    public void push(int e) {
        Node n = new Node(e);
        if(top == null) {
            top = n;
            min = e;
        } else {
            if( e < top.curmin ) {
                min = e;
            }
            n.next = top;
            top = n;
        }
        top.curmin = min;
        cap++;

    }

    public Object pop() {
        if(top != null) {
            int tv = top.data;
            top = top.next;
            if(top != null) {
                min = top.curmin;
            }
            cap--;
            return tv;
    
        }
        return null;
    }

    public Object min() {
        if(top != null) {
            return min;
        }
        return null;
    }

    public Object top() {
        return top.data;
    }

    public void print() {
        Node t = top;
        while( t != null ) {
            System.out.printf("%d ", t.data);
            t = t.next;
        }
        System.out.println();
    }
    public int getCapacity() {
        return cap;
    }
}
