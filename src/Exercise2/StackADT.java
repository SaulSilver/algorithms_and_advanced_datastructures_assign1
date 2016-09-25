package Exercise2;

import java.util.NoSuchElementException;

/**
 *
 * Created by Hatem on 21-Sep-16.
 */
public class StackADT implements A1Stack {
    private int stackSize = 0;
    private Node first = null;


    @Override
    public void push(Object element) {
        Node newNode = new Node(element);
        newNode.next = first;
        first = newNode;
        stackSize++;
    }

    @Override
    public Object pop() {
        if(first == null)
            throw new NoSuchElementException();
        Object element = first.value;
        first = first.next;
        stackSize--;
        return element;
    }

    @Override
    public Object peek() {
        if(first == null)
            throw new NoSuchElementException();
        return first.value;
    }

    @Override
    public int size() {
        return stackSize;
    }

    private class Node {

        private Object value;
        Node next = null;

        Node(Object v) {
            value = v;
        }
    }
}
