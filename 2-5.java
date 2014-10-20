/*
 * Given a circular linked list, implement an algorithm which returns node at the begin-
 * ning of the loop.
 */

package cc150.chapter2;
import java.util.Random;

import cc150.chapter2.*;
class Test2_5 {
    public static void main(String argv[]) {
        int n = 4;
        if(argv.length > 0) {
            n = Integer.parseInt(argv[0]);
        }
        Random rand = new Random(System.currentTimeMillis());
        // Create linked list with cycle
        List list = new List();
        Node tail = null;
        for(int i = 0; i < 10; i++) {
            tail = new Node(rand.nextInt(10));
            list.attach(tail);
        }
        list.print();
        // Make the tail point back to the nth node
        Node node = list.head;
        for(int i = 0;  node.next != null && i < n; i++) {
            node = node.next;
        }
        tail.next = node;
        System.out.printf("Loop start at %dth node\n", n);
        // Find the meeting point
        Node nx1 = list.head.next;
        Node nx2 = null;
        if(nx1 == null || nx1.next == null) {
            System.out.println("No loop at all");
            return;
        }
        nx2 = nx1.next;
        while(nx2 != null && nx1 != null && nx2 != nx1) {
            if(nx2.next == null) {
                System.out.println("No loop at all");
                return;
            }
            nx2 = nx2.next.next;
            nx1 = nx1.next;
        }
        // Find the loop start node
        nx1 = list.head;
        int i = 0;
        while(nx1 != nx2) {
            nx1 = nx1.next;
            nx2 = nx2.next;
            i++;
        }
        System.out.printf("Loop detected at %dth node with value %d\n", i, nx1.data);

    }
}
