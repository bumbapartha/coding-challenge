import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {

    private int id[];
    public UF(int n){
        id = new int[n];
        for (int i=0; i<n; i++){
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pr = find(p);
        int qr = find(p);
        id[pr] = qr;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p){
        int i = p;
        while(id[i] != i){
            i = id[i];
            id[i] = id[id[i]];
        }
        return i;
    }

    public int count() {
        return id.length;
    }


    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
