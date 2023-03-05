import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<>();
        int i = 0;
        while (i < n) {
            String str = StdIn.readString();
            queue.enqueue(str);
            i++;
        }
        i = 0;
        while (!queue.isEmpty()) {
            StdOut.println(queue.dequeue());
        }
    }
}