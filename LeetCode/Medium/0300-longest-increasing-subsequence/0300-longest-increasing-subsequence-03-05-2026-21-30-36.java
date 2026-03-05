// 1. state variables and fxn : f(i)->len of longest strictly increasing subsequence upto i
// 2. recurrence reln: if(nums[i]>nums[j]) for j is 0 to i-1 {maxForI = max(maxForI,dp[j]+1)}
// 3. base cases : f(0) -> 1 
class Solution {
    // // top down
    // private int[] nums;
    // private Map<Integer,Integer> memo = new HashMap<>();
    // public int dp(int i){
    //     if(i==0){
    //         return 1;
    //     }
    //     if(!memo.containsKey(i)){
    //         int maxForI = 1;
    //         for(int j=0;j<i;j++){
    //             if(nums[i]>nums[j]){
    //                 maxForI = Math.max(maxForI,dp(j)+1);
    //             }
    //         }
    //         memo.put(i,maxForI);
    //     }
    //     return memo.get(i);
    // }
    public int lengthOfLIS(int[] nums) {
        //this.nums = nums;
        int n = nums.length;
        if(n==1){
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int length = 0;
        // for(int num:memo.values()){
        //     length = Math.max(length,num);
        // }
        for(int num:dp){
            length=Math.max(length,num);
        }
        return length;
    }
}