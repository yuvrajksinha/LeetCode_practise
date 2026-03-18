class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n && nums[i]<=0;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int left=i+1,right=n-1;
                while(left<right){
                    int sum=nums[i]+nums[left]+nums[right];
                    if(sum==0){
                        result.add(List.of(nums[i],nums[left++],nums[right--]));
                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                    } else if(sum>0){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}