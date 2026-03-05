// 1. state variables and fxn : f(i) returns length of longest increasing subsequence upto i
// 2. recurrence relation : for(j->0 to i-1), if(nums[i]>nums[j]) {max(maxForI till then, dp(j)+1)}
// 3. base condition : f(0) = 1;
class Solution {
    // private int[] nums;
    // private int maxLength=0;
    // private Map<Integer,Integer> memo = new HashMap<>();
    // private int dp(int i){
    //     if(i==0){
    //         return 1;
    //     }
    //     if(!memo.containsKey(i)){
    //         int maxForI=1;
    //         for(int j=0;j<i;j++){
    //             if(nums[i]>nums[j]){
    //                 maxForI = Math.max(maxForI,dp(j)+1);
    //             }
    //         }
    //         memo.put(i,maxForI);
    //         maxLength = Math.max(maxLength,maxForI);
    //     }
    //     return memo.get(i);
    // }
    public int lengthOfLIS(int[] nums) {
        // this.nums = nums;
        int n=nums.length;
        if(n==1){
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            int maxForI=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxForI = Math.max(maxForI,dp[j]+1);
                }
            }
            dp[i]=maxForI;
        }
        int maxLength = 0;
        for(int num:dp){
            maxLength = Math.max(maxLength,num);
        }
        return maxLength;
    }
}