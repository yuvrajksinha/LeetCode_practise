class Solution {
    public int[] nums,memo1,memo2;
    public int dp(int i,int start,int[] memo){
        if(i<start){
            return 0;
        }
        if(memo[i]==-1){
            memo[i]=Math.max(dp(i-1,start,memo),dp(i-2,start,memo)+nums[i]);
        }
        return memo[i];
    }
    public int rob(int[] nums) {
        this.nums = nums;
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        this.memo1 = new int[n];
        this.memo2 = new int[n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo1,-1);
            Arrays.fill(memo2,-1);
        }
        int ifFirstRobbed = dp(n-2,0,memo1);
        int ifFirstNotRobbed = dp(n-1,1,memo2);

        return Math.max(ifFirstRobbed,ifFirstNotRobbed);
    }
}