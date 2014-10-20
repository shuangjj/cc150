/*
 * You have two numbers represented by a linked list, where each node contains a sin-
 * gle digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
 * the list. Write a function that adds the two numbers and returns the sum as a linked list.
*/

package cc150.chapter2;
import java.util.Random;

import cc150.chapter2.List;
import cc150.chapter2.Node;
class Test2_4 {
    public static void main(String argv[]) {
        
        Random rand = new Random(System.currentTimeMillis());
        // Instantiate two number list
        List num1 = new List();
        for(int i = 0; i < 5; i++) {
            Node dig = new Node(rand.nextInt(10));
            num1.attach(dig);
        }
        List num2 = new List();
        for(int i = 0; i < 5; i++) {
            Node dig = new Node(rand.nextInt(10));
            num2.attach(dig);
        }
        //
        num1.print();
        num2.print();
        // Addition
        Node node1 = num1.head;
        Node node2 = num2.head;
        List sum_list = new List();
        int carry = 0;
        while(node1.next != null && node2.next != null) {
            int sum = (node1.next.data + node2.next.data + carry) % 10;
            Node node_sum = new Node(sum);
            sum_list.attach(node_sum);

            carry = (node1.next.data + node2.next.data + carry) / 10;
            node1 = node1.next;
            node2 = node2.next;
        }
        // Num1 remaining
        while(node1.next != null) {
            int sum = (node1.next.data + carry) % 10;
            Node node_sum = new Node(sum);
            sum_list.attach(node_sum);

            carry = (node1.next.data + carry) / 10;
            node1 = node1.next;
        }
        // Num2 remaining
        while(node2.next != null) {
            int sum = (node2.next.data + carry) % 10;
            Node node_sum = new Node(sum);
            sum_list.attach(node_sum);

            carry = (node2.next.data + carry) / 10;
            node2 = node2.next;
        }
        sum_list.print();
    }

}
