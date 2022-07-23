package leetcode;

import java.util.Arrays;

public class M912SortAnArray {

    public static void main(String[] args) {
        M912SortAnArray mainObject = new M912SortAnArray();
        mainObject.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[] {5,2,3,1})));
        System.out.println(Arrays.toString(solution.sortArray(new int[] {5,1,1,2,0,})));
    }

    class Solution {
        public int[] sortArray(int[] nums) {
            return nums;
        }
    }
}
