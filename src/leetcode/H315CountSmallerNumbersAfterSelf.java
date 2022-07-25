package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H315CountSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        H315CountSmallerNumbersAfterSelf self = new H315CountSmallerNumbersAfterSelf();
        self.run();
    }

    private void run() {
        Solution solution = new Solution();
        Solution.Pair[] result = solution.countSmaller(new int[] {1,5,6,3,2,6,8,1,4,2,9,11,-1});
        System.out.println(Arrays.toString(result));
    }


    class Solution {
        Integer[] resultList;

        public Pair[] countSmaller(int[] nums) {
            resultList = new Integer[nums.length];
            Pair[] pairList = new Pair[nums.length];
            for(int i=0; i<nums.length; i++){
                pairList[i] = new Pair(nums[i], i);
            }
            return mergeSort(pairList, 0, nums.length-1);
        }

        private Pair[] mergeSort(Pair[] nums, int left, int right){
            if(left < right && left < nums.length){
                int mid = (left + right) / 2;
                Pair[] leftSortedArray = mergeSort(nums, left, mid);
                Pair[] rightSortedArray = mergeSort(nums, mid + 1, right);
                Pair[] sortedArray = merge(leftSortedArray, rightSortedArray);
                return sortedArray;
            }
            else if(left == right){
                return new Pair[] {nums[left]};
            }
            else {
                return new Pair[] {};
            }
        }

        private Pair[] merge(Pair[] leftSortedArray, Pair[] rightSortedArray) {
            Pair[] resultArray = new Pair[leftSortedArray.length+rightSortedArray.length];
            int i=0;
            int j = 0;
            int k = 0;
            while(i<leftSortedArray.length && j<rightSortedArray.length){
                if(leftSortedArray[i].value >= rightSortedArray[j].value){
                    resultArray[k] = leftSortedArray[i];
                    k++;
                    i++;
                }
                else {
                    resultArray[k] = rightSortedArray[j];
                    k++;
                    j++;
                }
            }
            while(i<leftSortedArray.length){
                resultArray[k] = leftSortedArray[i];
                k++;
                i++;
            }

            while(j<rightSortedArray.length){
                resultArray[k] = rightSortedArray[j];
                k++;
                j++;
            }
            return resultArray;
        }

        class Pair {
            int value;
            int index;
            Pair(int value, int index){
                this.value = value;
                this.index = index;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "value=" + value +
                        ", index=" + index +
                        '}';
            }
        }
    }

}
