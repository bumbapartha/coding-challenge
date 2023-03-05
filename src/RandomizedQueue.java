import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] itemArray;
    private int capacity;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.capacity = 1;
        this.size = 0;
        this.changeCapacity(this.capacity);
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Sarathi");
        queue.enqueue("Ghosh");
        queue.enqueue("Partha");
        queue.enqueue("Sarkar");
        queue.enqueue("Dipika");
        System.out.println(queue.sample());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        if (!queue.isEmpty()) {
            for (String name : queue) {
                System.out.println(name);
            }
        }
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return (size == 0);
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("null not supported");
        }
        if (size >= capacity - 1) {
            this.increaseCapacity();
        }
        itemArray[size] = item;
        size++;
    }

    private void increaseCapacity() {
        this.changeCapacity(this.capacity * 2);
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        } else if (size == 1) {
            Item dequeuedItem = this.itemArray[0];
            this.itemArray[0] = null;
            size = 0;
            return dequeuedItem;
        } else {
            int index = StdRandom.uniform(size - 1);
            Item dequeuedItem = this.itemArray[index];
            this.itemArray[index] = this.itemArray[this.size - 1];
            this.itemArray[this.size - 1] = null;
            this.size--;
            if (size * 4 < capacity) {
                this.decreaseSize();
            }
            return dequeuedItem;
        }
    }

    private void decreaseSize() {
        this.changeCapacity(this.capacity / 2);
    }

    private void changeCapacity(int newCapacity) {
        Item[] oldArray = this.itemArray;
        this.itemArray = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            this.itemArray[i] = oldArray[i];
        }
        this.capacity = newCapacity;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 1) {
            return this.itemArray[0];
        } else {
            int index = StdRandom.uniform(size - 1);
            return this.itemArray[index];
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        int[] randomIndex;
        int current;

        RandomizedQueueIterator() {
            this.current = 0;
            if (size == 0) {
                this.randomIndex = null;
            } else if (size == 1) {
                this.randomIndex = new int[]{0};
            } else if (size > 1) {
                this.randomIndex = StdRandom.permutation(size);
            }
        }

        @Override
        public boolean hasNext() {
            return (this.current < size);
        }

        @Override
        public Item next() {
            if (this.current >= size) {
                throw new NoSuchElementException("RandomizedQueue is empty");
            }
            Item item = itemArray[randomIndex[current]];
            current++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}