// 1. fxn f(i) where i is the step we are on, and it returns the no of steps to reach i
// 2. recurrence reln: f(i) = f(i-1) + f(i-2)
// 3. base cases: f(1)=1, f(2)= 1+1 = 2

class Solution {
    // Top down approach
    // Map<Integer,Integer> memo = new HashMap<>();
    // public int dp(int i){
    //     if(i<=2){
    //         return i;
    //     }
    //     if(!memo.containsKey(i)){
    //         memo.put(i,dp(i-1)+dp(i-2));
    //     }
    //     return memo.get(i);
    // }
    public int climbStairs(int n) {
        //bottom up approach
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}