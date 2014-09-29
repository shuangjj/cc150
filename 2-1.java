/*
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */

package cc150.chapter2;
import java.util.Random;
class Test2_1 {
    private static final int N = 10;
    public static void main(String argv[]) {
        Random rand = new Random(System.currentTimeMillis()); 
        // Create list with N nodes
        List list = new List();
        for(int i = 0; i < 10; i++) {
            Node node = new Node(rand.nextInt(10));
            list.attach(node) ;
        }
        list.print();
        // Sort the list
        list.sort();
        list.print();
        // Remove duplicate nodes 
        list.deduplicate();
        list.print();
    }
}
class List {
    Node head;
    private int len;
    public List() {
        head = new Node();
        len = 0;
    }
    // Attach to end of list
    public void attach(Node node) {
        Node n = head;
        while(n.next != null) {
            n = n.next;
        }
        n.next = node;
        len++;
    }   
    // Print list elements
    public void print() {
        Node node = head;
        while(node.next != null) {
            System.out.printf("%d ", node.next.data);
            node = node.next; 
        }
        System.out.println();
    }
    // Reverse singly linked list
    public void reverse() {
        Node node = head.next;
        Node pre = null;
        while(node != null) {
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        head.next = pre;
    }
    // Sort list
    public void sort() {
        Node start = head;
        for(int i = 0; i < len-1; i++) {
            Node node = start.next;
            Node pre = start;
            // Bubble up;
            while(node.next != null) {
                if(node.data > node.next.data) {
                    //System.out.printf("%d\n", node.data);
                    Node tmp = node.next;
                    node.next = tmp.next;
                    tmp.next = node;
                    pre.next = tmp;
                    pre = tmp;
                } else {
                    pre = node;
                    node = node.next;
                }
            }
            //System.out.println();
        }
    }
    // Remove duplicate
    public void deduplicate() {
        Node node = head.next;
        while(node.next != null) {
            if(node.next.data == node.data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }
}
class Node {
    int data; 
    Node next;
    public Node() {
        data = 0;
        next = null;
    }
    public Node(int data) {
        this.data = data;
        next = null;
    }

}
