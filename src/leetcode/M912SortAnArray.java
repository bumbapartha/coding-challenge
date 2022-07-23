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
            return mergeSort(nums, 0, nums.length-1);
        }

        public int[] mergeSort(int[] nums, int left, int right){
            if ( left < right ){
                int mid = (left + right) / 2;
                int[] array1 = mergeSort(nums, left, mid);
                int[] array2 = mergeSort(nums, mid+1, right);
                return merge(array1, array2);
            }
            else {
                return new int[]{nums[left]};
            }
        }

        private int[] merge(int[] array1, int[] array2) {
            int i = 0;
            int j = 0;
            int k = 0;
            int[] array3 = new int[array1.length+array2.length];
            while(i<array1.length && j<array2.length){
                if(array1[i]<array2[j]){
                    array3[k++] = array1[i++];
                }
                else {
                    array3[k++] = array2[j++];
                }
            }
            while(i<array1.length){
                array3[k++] = array1[i++];
            }
            while(j<array2.length) {
                array3[k++] = array2[j++];
            }
            return array3;
        }
    }
}
