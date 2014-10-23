package cc150.ds.queue;

import cc150.ds.tree.*;

public class MyQueue<E> {
    int size;
    QElement<E> front;
    QElement<E> back;

    public MyQueue() {
        size = 0;
        front = null;
        back = null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
    public void enqueue(E e)  {
        
        QElement<E> newNode = new QElement<E>(e);
        if(size == 0) {
            front = back = newNode;
        } else {
            front.next = newNode;
            front = front.next;
        }
        size++;
    }

    public E dequeue() {

        if(size < 1) return null;
        E removed = back.value;
        back = back.next;
        size--;
        return removed;
    }
    public int getSize() {
        return size;
    }
    public void showSize() {
        System.out.println("" + size);
    }
}


class QElement<E> {
    E value;
    QElement<E> next;
    public QElement(E v) {
        this.value = v;
        next = null;
    }
}

