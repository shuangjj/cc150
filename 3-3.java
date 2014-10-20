package cc150.chapter3;

import cc150.ds.stack.*;
import java.util.Random;

class Test3_3 {
    public static void main(String argv[]) {
        Random rand = new Random(System.currentTimeMillis());
        SetOfStack sos = new SetOfStack();
        for( int i = 0; i < 10; i++ ) {
            int num = rand.nextInt(10);
            //System.out.printf("%d ", num);
            sos.push(num);
        }
        System.out.println();
        /*
        Object e;
        while( (e = sos.pop()) != null ) {
            System.out.printf("%d ", e);
        }
        System.out.println();
        */
        int idx = 2;
        if(argv.length > 0) 
            idx = Integer.parseInt(argv[0]);
        Object pop = sos.popAt(idx);
        System.out.println("Pop at stack " + idx + ": " + pop +  "+" + sos.popAt(idx));
    }

}

class SetOfStack {
    private static final int CAPACITY = 4;
    int stack_num;
    Stack topStack; 

    public SetOfStack() {
        topStack = null;
        stack_num = 0;
    }
    /*
     * push function to SetOfStack
     */
    public void push(int e) {
        if(topStack == null) {
            topStack = new Stack();
            topStack.push(e);
            stack_num++;
        }  else {
            if(topStack.getCapacity() < CAPACITY) {
                topStack.push(e);
            } else {
                topStack.print();
                Stack s = new Stack();
                s.push(e);
                s.next = topStack;
                topStack = s;
                stack_num++;
            }
        }
    }
    /*
     * Pop function
     */
    public Object pop() {
        if( topStack == null ) return null;

        if( topStack.getCapacity() > 0 ) {
            return topStack.pop();
        } else {
            topStack = topStack.next;
            stack_num--;
            if(topStack == null) return null;
            return topStack.pop();
        }
    }
    public Object popAt(int index) {
        System.out.printf("%d : %d\n", stack_num, index);
        if(topStack == null || stack_num < index) return null;

        Stack s = topStack; 
        for(int i = 0; i < stack_num - index; i++) {
            s = s.next;
        }
        return s.pop();
    }
}
