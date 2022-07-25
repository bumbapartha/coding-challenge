package leetcode;

import java.util.Arrays;

public class M34FindFirstLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        M34FindFirstLastPositionOfElementInSortedArray obj = new M34FindFirstLastPositionOfElementInSortedArray();
        obj.run();
    }

    private void run() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[] {}, 0)));
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] index = new int[]{-1, -1};


            int found = binarySearchLeft(nums, 0, nums.length, target, 0);
            if(found >= 0 && found < nums.length && nums[found] == target){
                int left = binarySearchLeft(nums, 0, found, target, -0.1);
                int right = binarySearchLeft(nums, found, nums.length, target, 0.1);
                index[0] = left;
                index[1] = right-1;
            }


            return index;
        }
        private int binarySearchLeft(int[] nums, int left, int right, int target, double frac){
            if(left == right){
                return left;
            }
            else if (left < right){
                int mid = (left + right) /2;
                if(nums[mid] < ((double) target + frac)) {
                    return binarySearchLeft(nums, mid+1, right, target, frac);
                }
                else {
                    return binarySearchLeft(nums, left, mid, target, frac);
                }
            }
            else {
                return -1;
            }
        }
    }
}
