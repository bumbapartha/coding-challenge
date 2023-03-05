import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation { 

    private boolean[] openedSite;
    private WeightedQuickUnionUF unionFind;

    private int countOfOpenSite = 0;
    private int n;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) { 
        if (n <= 0) { 
            throw new IllegalArgumentException();
        }
        this.unionFind = new WeightedQuickUnionUF(n * n + 2);
        this.openedSite = new boolean[n * n + 2];
        this.n = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) { 
        if (isOpen(row, col)) { 
            return;
        }
        int cell = to1DIndex(row, col);
        openedSite[cell] = true;
        countOfOpenSite++;
        if (row == 1) { 
            unionFind.union(0, cell);
        }
        else if (row == n) { 
            unionFind.union(n * n + 1, cell);
        }

        if (row > 1 && isOpen(row-1, col)) { 
            unionFind.union(to1DIndex(row-1, col), cell);
        }
        if (col > 1 && isOpen(row, col-1)) { 
            unionFind.union(to1DIndex(row, col-1), cell);
        }
        if (row < n && isOpen(row+1, col)) { 
            unionFind.union(to1DIndex(row+1, col), cell);
        }
        if (col < n && isOpen(row, col+1)) { 
            unionFind.union(to1DIndex(row, col+1), cell);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) { 
        int cell = to1DIndex(row, col);
        return openedSite[cell];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) { 
        int cell = to1DIndex(row, col);
        return  (unionFind.find(0) == unionFind.find(cell));
    }

    // returns the number of open sites
    public int numberOfOpenSites() { 
        return countOfOpenSite;
    }

    // does the system percolate?
    public boolean percolates() { 
        return  (unionFind.find(0) == unionFind.find(n*n+1));
    }

    private int to1DIndex(int row, int col) { 
        if (row < 1 || row > n || col < 1 || col > n) { 
            throw new IllegalArgumentException();
        }
        return ((row - 1) * n) + (col - 1) + 1;
    }


    // test client (optional)
    public static void main(String[] args) { 

    }
}