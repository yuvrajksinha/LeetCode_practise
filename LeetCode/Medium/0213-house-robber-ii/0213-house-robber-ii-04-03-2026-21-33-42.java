class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }

        int firstNotRobbed = dp(nums,1,n-1);
        int firstRobbed = dp(nums,0,n-2);

        return Math.max(firstNotRobbed,firstRobbed); 
    }
    public int dp(int[] nums,int start,int end){
        int prev1House = 0;
        int prev2House = 0;
        for(int i=start;i<=end;i++){
            int current = Math.max(prev1House,prev2House+nums[i]);
            prev2House = prev1House;
            prev1House = current;
        }
        return prev1House;
    }
}