package cc150.chapter3;

import cc150.ds.stack.*;
import java.util.Random;

class Test3_5 {
    public static void main(String argv[]) {
        Random rand = new Random();        
        MyQueue myqueue = new MyQueue();
        for(int i = 0; i < 10; i++) {
            int item = rand.nextInt(10);
            System.out.printf("%d ", item);
            myqueue.enqueue(item);
        }
        System.out.println();
        //myqueue.print();
        // Dequeue 
        Object obj;
        while( (obj  = myqueue.dequeue() ) != null ) {
            System.out.printf("%d ", (int)obj);
        }
        System.out.println();

    }
}


class MyQueue {
    Stack enStack;
    Stack deStack;
    boolean isEnStack;

    public MyQueue() {
        enStack = new Stack();
        deStack = new Stack();
        isEnStack = true;
    }

    public void enqueue(int item) {
        if(isEnStack) {
            enStack.push(item); 
        } else {
            Object top;
            while((top = deStack.pop()) != null) {
                enStack.push((int)top);
            }    
            isEnStack = true;
            enStack.push(item);
        }
    }

    public Object dequeue() {
        if(!isEnStack) {
            return deStack.pop();
        } else {
            Object top;
            while( (top = enStack.pop()) != null ) {
                deStack.push((int)top);
            }
            isEnStack = false;
            return deStack.pop();
        }
    }
    
    public void print() {
        if( isEnStack ) {
            enStack.print();
        } else {
            deStack.print();
        }
    }


}

