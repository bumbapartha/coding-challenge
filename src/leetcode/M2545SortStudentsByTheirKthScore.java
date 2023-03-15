package leetcode;

import java.util.Arrays;

public class M2545SortStudentsByTheirKthScore {

    class Solution {

        //Bubble sort
        public int[][] sortTheStudents(int[][] score, int k) {
            for(int i=0; i<score.length; i++) {
                int maxKthScore = score[i][k];
                int maxScoreIndex = i;
                for (int student = i+1; student < score.length; student++) {
                    int kthScore = score[student][k];
                    if(maxKthScore < kthScore){
                        maxKthScore = kthScore;
                        maxScoreIndex = student;
                    }
                }
                int temp[] = score[i];
                score[i] = score[maxScoreIndex];
                score[maxScoreIndex] = temp;
            }
            return score;
        }
    }

    public static void main(String[] args) {
        M2545SortStudentsByTheirKthScore program = new M2545SortStudentsByTheirKthScore();
        program.run();
    }

    public void run() {
        M2545SortStudentsByTheirKthScore.Solution solution = new M2545SortStudentsByTheirKthScore.Solution();
        int[][] result = solution.sortTheStudents(new int[][] {new int[]{10,6,9,1}, new int[]{7,5,11,2}, new int[]{4,8,3,15}}, 2);
        System.out.println(Arrays.deepToString(result));
    }
}
