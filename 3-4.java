
/*
 * Restricted Tower of Hanoi
 */
package cc150.chapter3;
import cc150.ds.stack.*;
import java.util.Random;

class Test3_4 {
    public static void main(String argv[]) {
        Random rand = new Random(System.currentTimeMillis()); 
        Stack src = new Stack();
        Stack aux = new Stack();
        Stack dst = new Stack();
        /* Initialize source disks */
        for(int i = 0; i < 10; i++) {
            src.push(rand.nextInt(10));
        }
        src.print();
        /* Recursively move disks from 1st rod to 3rd rod */
        move(10, src, aux, dst);
        dst.print();
        src.print();
        aux.print();
    }

    public static void move(int n, Stack src, Stack aux, Stack dst) {
        if(n < 1) {
            return;
        }
        /* Move top n-1 disks from 1st rod to 3rd rod recursively */
        move(n-1, src, aux, dst); 
        /* Move the bottom disk from 1st to 2nd */
        aux.push((int)src.pop());
        /* Move n-1 disks from 3rd back to 1st rod */
        move(n-1, dst, aux , src);
        /* Move bottom disk from 2nd to 3rd */
        dst.push((int)aux.pop());
        /* Move n-1 from 1st to 3rd */
        move(n-1, src, aux, dst);

    }
}
