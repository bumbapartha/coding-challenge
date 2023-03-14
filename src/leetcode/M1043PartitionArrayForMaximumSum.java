package leetcode;

public class M1043PartitionArrayForMaximumSum {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] result = new int[n];
            result[0] = arr[0];

            for(int i=0; i<n; i++){
                int max = 0;
                for(int j=i; j>i-k && j>=0; j--){
                    if(max < arr[j]){
                        max = arr[j];
                    }
                    int currentResult = max * (i-j+1) + ((j>0) ? result[j-1] : 0);
                    if(result[i] < currentResult){
                        result[i] = currentResult;
                    }
                }
            }
            return result[n-1];
        }
    }

    public static void main(String[] args) {
        M1043PartitionArrayForMaximumSum program = new M1043PartitionArrayForMaximumSum();
        program.run();
    }

    public void run() {
        M1043PartitionArrayForMaximumSum.Solution solution = new M1043PartitionArrayForMaximumSum.Solution();
        int result = solution.maxSumAfterPartitioning(new int[] {1,15,7,9,2,5,10}, 3);
        System.out.println(result);
    }
}
