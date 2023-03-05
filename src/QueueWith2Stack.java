import java.util.NoSuchElementException;

public class QueueWith2Stack {

    Stack inbox;
    Stack outbox;
    public QueueWith2Stack() {
        inbox = new Stack();
        outbox = new Stack();
    }

    public static void main(String[] args) {
        QueueWith2Stack queue = new QueueWith2Stack();
        queue.enqueue("Sarathi");
        queue.enqueue("Ghosh");
        queue.enqueue("Partha");
        queue.enqueue("Sarkar");
        queue.enqueue("Dipika");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    public boolean isEmpty() {
        return this.inbox.isEmpty() && this.outbox.isEmpty();
    }

    public void enqueue(String item) {
        this.inbox.push(item);
    }

    public String dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (this.outbox.isEmpty()) {
            while (!this.inbox.isEmpty()) {
                this.outbox.push(this.inbox.pop());
            }
        }
        return this.outbox.pop();
    }

    private class Stack {
        private Node head;

        public Stack() {
            this.head = null;
        }

        public boolean isEmpty() {
            return (this.head == null);
        }

        public void push(String item) {
            if (this.head == null) {
                this.head = new Node();
                this.head.item = item;
            } else {
                Node node = new Node();
                node.item = item;
                node.next = this.head;
                this.head = node;
            }
        }

        public String pop() {
            if (this.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            } else {
                Node node = this.head;
                this.head = this.head.next;
                return node.item;
            }
        }

        private class Node {
            String item;
            Node next;
        }
    }
}
