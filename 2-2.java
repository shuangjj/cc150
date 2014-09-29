/*
 * Implement an algorithm to find the nth to last element of a singly linked list
 *
 */
package cc150.chapter2;
import java.util.Random;

import cc150.chapter2.List;
import cc150.chapter2.Node;

class Test2_2 {
    public static void main(String argv[]) {
        int N = 10;
        int ntolast = 1;
        if(argv.length > 0) {
            ntolast = Integer.parseInt(argv[0]);
        }
        Random rand = new Random(System.currentTimeMillis());
        List list = new List();
        for(int i = 0; i < N; i++) {
            Node node = new Node(rand.nextInt(10));
            list.attach(node);
        }
        list.print();
        // Reverse list
        list.reverse();
        list.print();
        // Find the nth element
        Node node = list.head;
        int i = ntolast;
        while(node.next != null && (i-- > 0)) { 
            node = node.next;
        }
        if(i > 0) {
            System.out.println("Out of bound " + ntolast);
        }        
        System.out.printf("The %dth to last element of list is %d\n", ntolast, node.data);
    }
}
