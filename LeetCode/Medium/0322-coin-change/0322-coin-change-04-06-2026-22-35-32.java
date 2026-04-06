class Solution {
    public int[] memo,coins;
    public int amount;
    public int dp(int i){
        if(i==0){
            return 0;
        }
        if(i<0){
            return -1;
        }
        if(memo[i]==0){
            int fewest = Integer.MAX_VALUE;
            for(int coin:coins){
                int result = dp(i-coin);
                if(result>=0){
                    fewest = Math.min(fewest,1+result);
                }
            }
            memo[i]=(fewest==Integer.MAX_VALUE)?-1:fewest;
        }
        return memo[i];
    }
    public int coinChange(int[] coins, int amount) {
        this.coins=coins;
        this.memo=new int[amount+1];
        return dp(amount);
    }
}