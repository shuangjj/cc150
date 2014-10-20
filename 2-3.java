/*
 * Implement an algorithm to delete a node in the middle of a single linked list, given
 * only access to that node.
 */
package cc150.chapter2;
import java.util.Random;

import cc150.chapter2.*;

class Test2_3 {
    public static void main(String argv[]) {
        int todel = 4;
        if(argv.length > 0) {
            todel = Integer.parseInt(argv[0]);
        }
        Random rand = new Random(System.currentTimeMillis());
        // Create a list instance
        List list = new List();
        Node nodedel = null;
        for(int i = 0; i < 10; i++) {
            Node n = new Node(rand.nextInt(10));
            if(i == todel-1)  nodedel = n;
            list.attach(n);
        }
        System.out.printf("Remove %dth node of the list: ", todel);
        list.print();
        // Remove
        if(nodedel != null && nodedel.next != null) {
            Node next = nodedel.next;
            nodedel.data = next.data;
            nodedel.next = next.next;
        } else {
            System.out.println("Could not remove the last one!");
        }
        list.print();

    }
}
