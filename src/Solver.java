import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {
    private int totalMoves = -1;
    private Iterable<Board> solutionList;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if(initial == null){
            throw new IllegalArgumentException();
        }
        SearchNode goalNode = null;
        MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>();
        SearchNode searchNode = new SearchNode(initial, 0, null);
        minPQ.insert(searchNode);
        while (!minPQ.isEmpty()) {
            SearchNode minSearchNode = minPQ.delMin();
            if (minSearchNode.board.isGoal()) {
                this.totalMoves = minSearchNode.moves;
                goalNode = minSearchNode;
                break;
            }
            if (5 * initial.manhattan() < minSearchNode.board.manhattan()) {
                break;
            }
            for (Board neighbor : minSearchNode.board.neighbors()) {
                if (minSearchNode.parent != null) {
                    if (minSearchNode.parent.board.equals(neighbor)) {
                        continue;
                    } else if (minSearchNode.parent.parent != null) {
                        if (minSearchNode.parent.parent.board.equals(neighbor)) {
                            continue;
                        } else if (minSearchNode.parent.parent.parent != null) {
                            if (minSearchNode.parent.parent.parent.board.equals(neighbor)) {
                                continue;
                            }
                        }
                    }
                }
                minPQ.insert(new SearchNode(neighbor, minSearchNode.moves + 1, minSearchNode));
            }
        }
        solutionList = getSolution(goalNode);
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return (totalMoves != -1);
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return totalMoves;
    }

    private Iterable<Board> getSolution(SearchNode goalNode) {
        if (goalNode == null) {
            return null;
        }
        List<Board> solutionPath = new ArrayList<>();
        SearchNode tempNode = goalNode;
        while (tempNode != null) {
            solutionPath.add(tempNode.board);
            tempNode = tempNode.parent;
        }
        Collections.reverse(solutionPath);
        return solutionPath;
    }
    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return solutionList;
    }

    private class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final int moves;
        private final int manhattanPriority;
        private final SearchNode parent;

        SearchNode(Board board, int moves, SearchNode parent) {
            this.board = board;
            this.moves = moves;
            this.parent = parent;
            this.manhattanPriority = board.manhattan() + moves;
        }

        public int manhattanPriority() {
            return manhattanPriority;
        }

        @Override
        public int compareTo(SearchNode node) {
            return this.manhattanPriority() - node.manhattanPriority();
        }
    }

}