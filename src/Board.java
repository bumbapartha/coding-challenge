import java.util.ArrayList;
import java.util.List;

public final class Board {

    private final int[][] tiles;

    private final int hammingDistance;
    private final int manhattanDistance;

    private int[] zeroTileCord;


    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        int hDistance = 0;
        int mDistance = 0;
        int correctNumber = 1;
        this.tiles = new int[tiles.length][tiles.length];
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                if (tiles[row][col] == 0) {
                    this.zeroTileCord = new int[]{row, col};
                } else {
                    if (tiles[row][col] != correctNumber) {
                        hDistance++;
                    }
                    int desiredRow = (tiles[row][col] - 1) / this.dimension();
                    int desiredCol = (tiles[row][col] - 1) % this.dimension();
                    int distance = (Math.abs(desiredRow - row) + Math.abs(desiredCol - col));
                    mDistance += distance;
                }
                this.tiles[row][col] = tiles[row][col];
                correctNumber++;
            }
        }
        this.hammingDistance = hDistance;
        this.manhattanDistance = mDistance;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] data = new int[][]
                {
                        {3, 2, 0},
                        {7, 8, 5},
                        {6, 4, 1},
                };
        Board myBoard = new Board(data);
        String expectedToString = "3\n 3 2 0\n 7 8 5\n 6 4 1";
        if (!myBoard.toString().equals(expectedToString)) {
            throw new AssertionError("toString fail to match:\nActual\n" + myBoard + "\nExpected\n" + expectedToString);
        }

        int[][] data1 = new int[][]
                {
                        {8, 1, 3},
                        {4, 0, 2},
                        {7, 6, 5},
                };
        Board myBoard1 = new Board(data1);
        if (myBoard1.hamming() != 5) {
            throw new AssertionError("hamming fail to match:\nActual\n" + myBoard1.hamming() + "\nExpected\n" + 5);
        }
        if (myBoard1.manhattan() != 10) {
            throw new AssertionError("manhattan fail to match:\nActual\n" + myBoard1.manhattan() + "\nExpected\n" + 10);
        }

        int[][] data2 = new int[][]
                {
                        {1, 0, 3},
                        {4, 2, 5},
                        {7, 8, 6},
                };
        Board myBoard2 = new Board(data2);
        List<Board> list = (List<Board>) myBoard2.neighbors();
        if (list.size() != 3) {
            throw new AssertionError("neighbors fail to match:\nActual\n" + list.size() + "\nExpected\n" + 3);
        }
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tiles.length);
        for (int row = 0; row < tiles.length; row++) {
            sb.append("\n");
            for (int col = 0; col < tiles[row].length; col++) {
                sb.append(" ");
                sb.append(tiles[row][col]);
            }
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place
    public int hamming() {
        return hammingDistance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattanDistance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y instanceof Board) {
            if (((Board) y).dimension() == this.dimension()
                    && this.hamming() == ((Board) y).hamming()
                    && this.manhattan() == ((Board) y).manhattan()) {
                for (int row = 0; row < tiles.length; row++) {
                    for (int col = 0; col < tiles[row].length; col++) {
                        if (this.tiles[row][col] != ((Board) y).tiles[row][col]) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private Iterable<Board> getNeighbors(int[][] newTiles) {
        List<Board> neighborsList = new ArrayList<>();
        int row = zeroTileCord[0];
        int col = zeroTileCord[1];

        if (row > 0) {
            newTiles[row][col] = newTiles[row - 1][col];
            newTiles[row - 1][col] = 0;
            neighborsList.add(new Board(newTiles));
            newTiles[row - 1][col] = newTiles[row][col];
            newTiles[row][col] = 0;
        }
        if (col > 0) {
            newTiles[row][col] = newTiles[row][col - 1];
            newTiles[row][col - 1] = 0;
            neighborsList.add(new Board(newTiles));
            newTiles[row][col - 1] = newTiles[row][col];
            newTiles[row][col] = 0;
        }
        if (row < dimension() - 1) {
            newTiles[row][col] = newTiles[row + 1][col];
            newTiles[row + 1][col] = 0;
            neighborsList.add(new Board(newTiles));
            newTiles[row + 1][col] = newTiles[row][col];
            newTiles[row][col] = 0;
        }
        if (col < dimension() - 1) {
            newTiles[row][col] = newTiles[row][col + 1];
            newTiles[row][col + 1] = 0;
            neighborsList.add(new Board(newTiles));
            newTiles[row][col + 1] = newTiles[row][col];
            newTiles[row][col] = 0;
        }
        return neighborsList;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return this.getNeighbors(this.tiles);
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        if(tiles[0][0] != 0) {
            if(tiles[0][1] != 0) {
                int temp0 = tiles[0][0];
                int temp1 = tiles[0][1];
                tiles[0][0] = temp1;
                tiles[0][1] = temp0;
                Board tempBoard = new Board(tiles);
                tiles[0][0] = temp0;
                tiles[0][1] = temp1;
                return tempBoard;
            }
            else {
                int temp0 = tiles[0][0];
                int temp1 = tiles[1][0];
                tiles[0][0] = temp1;
                tiles[1][0] = temp0;
                Board tempBoard = new Board(tiles);
                tiles[0][0] = temp0;
                tiles[1][0] = temp1;
                return tempBoard;
            }
        }
        else {
            int temp0 = tiles[1][0];
            int temp1 = tiles[1][1];
            tiles[1][0] = temp1;
            tiles[1][1] = temp0;
            Board tempBoard = new Board(tiles);
            tiles[1][0] = temp0;
            tiles[1][1] = temp1;
            return tempBoard;
        }
    }

}