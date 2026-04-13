class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int distOfTarget=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                distOfTarget=Math.min(distOfTarget,Math.abs(i-start));
            }
        }
        return distOfTarget;
    }
}