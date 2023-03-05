import java.util.Arrays;

public class LeetCode1277 {

    public static void main(String[] args) {
        LeetCode1277.Solution sol = new LeetCode1277.Solution();
        System.out.println(sol.countSquares(new int[][] {
                new int[] {0,1,1,1},
                new int[] {1,1,1,1},
                new int[] {0,1,1,1}
        }));
    }

    static class Solution {


        public int countSquares(int[][] matrix) {

            int count = 0;
            for(int c=0; c<matrix[0].length; c++){
                count += matrix[0][c];
            }
            for(int r=1; r<matrix.length; r++){
                if(matrix[r][0] == 1) {
                    count += matrix[r][0];
                }
                for(int c=1; c<matrix[0].length; c++){
                    if(matrix[r][c] == 1) {
                        int min = Math.min(matrix[r-1][c - 1], matrix[r-1][c]);
                        min = Math.min(matrix[r][c - 1], min);
                        matrix[r][c] = 1 + min;
                        count += matrix[r][c];
                    }
                }
            }
            return count;
        }
    }

   static class Approch1Solution {
        public int countSquares(int[][] matrix) {
            int count = 0;
            lengthWiseCount = new int[Math.max(matrix.length, matrix[0].length)];

            for(int r=0; r<matrix.length; r++){
                for(int c=0; c<matrix[0].length; c++){
                    if(matrix[r][c] != 0) {
                        int n = searchSquares(matrix, r, c, 1);
                        count += n*(n+1)*(2*n+1)/6;

                    }
                }
            }
            System.out.println(Arrays.toString(lengthWiseCount));
            return count;
        }
        int[] lengthWiseCount;
        public int searchSquares(int[][] matrix, int r, int c, int l) {
            if(r+l > matrix.length){
                return l;
            }
            if(c+l > matrix[0].length){
                return l;
            }
            for(int i=r; i<=r+l-1; i++){
                if(matrix[i][c+l-1] == 0){
                    return l;
                }
            }
            for(int j=c; j<=c+l-1; j++){
                if(matrix[r+l-1][j] == 0){
                    return l;
                }
            }
            return searchSquares(matrix, r, c, l+1);
        }
    }
}
