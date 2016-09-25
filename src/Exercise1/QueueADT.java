package Exercise1;

/**
 * Implement a Queue ADT for generic element types that supports the following operations:

 enqueue an element in O(1)

  dequeue an element in O(1)

 peek the front element in O(1)

  return queue length in O(1)
 * Created by Hatem on 21-Sep-16.
 */
public class QueueADT implements A1Queue {

    private int queueSize = 0;
    private Node head = null;

    @Override
    public void enqueue(Object element) {
        if(head == null)
            head = new Node(element);
        else {
            Node node = head;
            while (node.next != null)
                node = node.next;
            node.next = new Node(element);
        }
        queueSize++;
    }

    @Override
    public Object dequeue() {
        if (queueSize == 0)
            throw new IndexOutOfBoundsException("There is no queue.");
        else {
            Node node = head;
            head = node.next;
            queueSize--;
            return node.value;
        }
    }

    @Override
    public Object peek() {
        if (queueSize == 0)
            throw new IndexOutOfBoundsException("There is no queue.");
        else
            return head.value;
    }

    @Override
    public int length() {
        return queueSize;
    }

    private class Node {

        private Object value;
        Node next = null;

        Node(Object v) {
            value = v;
        }
    }
}
