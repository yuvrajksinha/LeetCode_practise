class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(n<4){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                for(int j=i+1;j<n-2;j++){
                    if(j==i+1 || nums[j]!=nums[j-1]){
                        int left=j+1,right=n-1;
                        while(left<right){
                            long sum = nums[i]+nums[j];
                            sum+=nums[left]+nums[right];
                            if(sum>target){
                                right--;
                            } else if(sum<target){
                                left++;
                            } else {
                                result.add(List.of(nums[i],nums[j],nums[left++],nums[right--]));
                                while(left<right && nums[left]==nums[left-1]){
                                    left++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}