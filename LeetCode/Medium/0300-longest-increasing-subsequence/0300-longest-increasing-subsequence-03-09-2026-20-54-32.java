// 1. dp(i) : return the longest increasing subsequence till i
// 2. recurrence relation: dp(i)=max(dp(i),dp(j)+1) for 0<=j<n when nums[i]>nums[j]
// 3. base case: i==0 -> return 1
class Solution {
    // top down
    // private Map<Integer,Integer> memo = new HashMap<>();
    // private int[] nums;
    // private int maxLength=0;
    // public int dp(int i){
    //     if(i==0){
    //         return 1;
    //     }
    //     if(!memo.containsKey(i)){
    //         int maxTillI=1;
    //         for(int j=0;j<i;j++){
    //             if(nums[i]>nums[j]){
    //                 maxTillI = Math.max(maxTillI,dp(j)+1);
    //             }
    //         }
    //         memo.put(i,maxTillI);
    //         maxLength = Math.max(maxLength,maxTillI);
    //     }
    //     return memo.get(i);
    // }
    public int lengthOfLIS(int[] nums) {
        // top down
        // this.nums=nums;
        // dp(nums.length-1);
        // return maxLength;
        int n = nums.length;
        if(n==1){
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int maxLength = 0;
        for(int num:dp){
            maxLength = Math.max(maxLength,num);
        }
        return maxLength;
    }
}