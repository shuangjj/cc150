/*
 * How would you design a stack which, in addition to push and pop, also has a function
 * min which returns the minimum element? Push, pop and min should all operate in
 * O(1) time
 */

package cc150.chapter3;
import cc150.ds.*;

import java.util.Random;

class Test3_2 {
    public static void main(String argv[]) {
        Random rand = new Random(System.currentTimeMillis());
        Stack stack = new Stack();
        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.print();
        stack.pop();
        stack.push(-4);
        stack.print();
        System.out.println("Minimum element is " + stack.min());
    }
}

