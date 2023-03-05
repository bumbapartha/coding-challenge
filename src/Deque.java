import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;

    private int size = 0;

    // construct an empty deque
    public Deque() {
        this.head = null;
        this.tail = null;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> queue = new Deque<>();
        queue.addFirst("Sarathi");
        queue.addLast("Ghosh");
        queue.addFirst("Partha");
        System.out.println(queue.removeLast());
        System.out.println(queue.removeFirst());
        System.out.println(queue.size());
        System.out.println(queue.removeFirst());
        queue.addFirst("Sarkar");
        queue.addFirst("Dipika");
        for (String name : queue) {
            System.out.println(name);
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        return (this.head == null);
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("null not supported");
        }
        Node node = new Node(item);
        if (size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("null not supported");
        }
        Node node = new Node(item);
        if (size == 0) {
            this.head = node;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
        }
        this.tail = node;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        } else if (size == 1) {
            Item item = this.head.item;
            this.head = null;
            this.tail = null;
            size--;
            return item;
        } else {
            Item item = this.head.item;
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            return item;
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        } else if (size == 1) {
            Item item = this.tail.item;
            this.head = null;
            this.tail = null;
            size--;
            return item;
        } else {
            Item item = this.tail.item;
            this.tail = this.tail.prev;
            this.tail.next = null;
            size--;
            return item;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node prev;

        Node(Item item) {
            this.item = item;
        }
    }

    private class DequeIterator implements Iterator<Item> {
        Node current;

        DequeIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return (this.current != null);
        }

        @Override
        public Item next() {
            if (this.current == null) {
                throw new NoSuchElementException("Deque is empty");
            }
            Item item = this.current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}