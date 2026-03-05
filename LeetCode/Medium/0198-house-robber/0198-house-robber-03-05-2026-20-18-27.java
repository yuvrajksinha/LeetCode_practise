// 1. state variables and fxn : f(i) -> return the max money we can rob upto ith house
// 2. recurrence reln: f(i) = max(f(i-1) , nums[i]+f(i-2))
// 3. base cases : f(0): nums[0], f(1)=max(nums[0],nums[1])

class Solution {
    // Top down
    // private int[] nums;
    // private Map<Integer,Integer> memo = new HashMap<>();
    // public int dp(int i){
    //     if(i==0){
    //         return nums[0];
    //     }
    //     if(i==1){
    //         return Math.max(nums[0],nums[1]);
    //     }
    //     if(!memo.containsKey(i)){
    //         memo.put(i,Math.max(dp(i-1),nums[i]+dp(i-2)));   
    //     }
    //     return memo.get(i);
    // }
    public int rob(int[] nums) {
        // this.nums = nums;
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}