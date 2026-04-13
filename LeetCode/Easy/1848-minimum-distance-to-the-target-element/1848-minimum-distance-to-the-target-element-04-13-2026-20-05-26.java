class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int distOfTarget=Integer.MAX_VALUE;
        for(int left=start;left>=0;left--){
            if(nums[left]==target){
                distOfTarget=Math.min(distOfTarget,start-left);
                break;
            }
        }
        for(int right=start;right<nums.length;right++){
            if(nums[right]==target){
                distOfTarget=Math.min(distOfTarget,right-start);
                break;
            }
        }
        return distOfTarget;
    }
}