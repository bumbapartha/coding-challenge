package leetcode;

public class M322CoinChange {

    public static void main(String[] args) {
        System.out.println((new Solution()).coinChange(new int[]{1,2,3}, 307));
    }

    static class Solution {

        public int coinChange(int[] coins, int amount) {
            if(amount < 0){
                return -1;
            }
            int[] minCount = new int[amount+1];
            for(int i=1; i<=amount; i++){
                minCount[i] = Integer.MAX_VALUE;
            }
            for(int i=1; i <= amount; i++){
                for(int j=0; j < coins.length; j++){
                    if(i-coins[j] >= 0){
                        minCount[i] = Math.min(minCount[i-coins[j]]+1, minCount[i]);
                    }
                }
            }
            if(minCount[amount] == Integer.MAX_VALUE){
                return -1;
            }

            return minCount[amount];
        }
    }
}
