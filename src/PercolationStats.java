import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;
    
    // perform independent trials on an n-by-n grid
    private final double[] results;
    private final int n;
    private final int trials;


    public PercolationStats(int n, int trials) {
        int openSites = 0;
        results = new double[trials];
        this.n = n;
        this.trials = trials;
        for (int t = 0; t < trials; t++) {
            Percolation percolation = new Percolation(n);
            do {
                percolation.open(StdRandom.uniformInt(n) + 1, StdRandom.uniformInt(n) + 1);
            } while (!percolation.percolates());
            openSites = percolation.numberOfOpenSites();
            results[t] = ((double) openSites) / (n * n);
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        Stopwatch sw = new Stopwatch();
        PercolationStats percolationStats = new PercolationStats(n, trails);
        System.out.printf("mean                     = %f\n", percolationStats.mean());
        System.out.printf("stddev                   = %f\n", percolationStats.stddev());
        System.out.printf("95%% confidence interval = %f, %f\n",
                percolationStats.confidenceLo(), percolationStats.confidenceHi());

        System.out.println("------");
        System.out.printf("Total time: %f secs. (for N=%d, T=%d)",
                sw.elapsedTime(), n, trails);
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev()) / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev()) / Math.sqrt(trials);
    }
}
