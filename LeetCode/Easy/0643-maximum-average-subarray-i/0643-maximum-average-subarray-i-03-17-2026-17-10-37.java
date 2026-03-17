class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        double sum=0;
        for(int right=0;right<k;right++){
            sum+=nums[right];
        }
        double maxAverage=sum;
        for(int right=k;right<n;right++){
            sum+=nums[right];
            sum-=nums[left++];
            maxAverage = Math.max(maxAverage, sum);
        }
        return maxAverage/k;
    }
}